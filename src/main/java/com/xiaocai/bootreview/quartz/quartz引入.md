1.引入依赖
~~~xml
 <!--springboot项目集成quartz依赖-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-quartz</artifactId>
        </dependency>
~~~
2.
~~~
drop table if exists qrtz_fired_triggers;      -- 1 保存已经触发的触发器状态信息
drop table if exists qrtz_paused_trigger_grps; -- 2 存放暂停掉的触发器表表
drop table if exists qrtz_scheduler_state;     -- 3 调度器状态表
drop table if exists qrtz_locks;               -- 4 存储程序的悲观锁的信息(假如使用了悲观锁)
drop table if exists qrtz_simple_triggers;     -- 7 简单的触发器表
drop table if exists qrtz_simprop_triggers;    -- 8 存储两种类型的触发器表
drop table if exists qrtz_cron_triggers;       -- 9 定时触发器表
drop table if exists qrtz_blob_triggers;       -- 10 以blob 类型存储的触发器
drop table if exists qrtz_calendars;           -- 11 日历信息表
drop table if exists qrtz_triggers;            -- 6 触发器表
drop table if exists qrtz_job_details;         -- 5 job 详细信息表
~~~

3.
~~~
-- 1、 存储与已触发的 trigger 相关的状态信息，以及相联 job 的执行信息
create table qrtz_fired_triggers (
    `sched_name` varchar(120)  not null comment '计划名称',
    `entry_id` varchar(95)  not null comment '组标识',
    `trigger_name` varchar(200)  not null comment '触发器名称',
    `trigger_group` varchar(200)  not null comment '触发器组',
    `instance_name` varchar(200)  not null comment '当前实例的名称',
    `fired_time` bigint(13) not null comment '当前执行时间',
    `sched_time` bigint(13) not null comment '计划时间',
    `priority` int(11) not null comment '权重',
    `state` varchar(16)  not null comment '状态',
    `job_name` varchar(200)   default null comment '作业名称',
    `job_group` varchar(200)   default null  comment '作业组',
    `is_nonconcurrent` varchar(1)   default null  comment '是否并行',
    `requests_recovery` varchar(1)   default null  comment '是否要求唤醒',
    primary key (sched_name,entry_id)
) engine=innodb default charset=utf8 comment = '保存已经触发的触发器状态信息';

-- 2、 存放暂停掉的触发器表表
create table qrtz_paused_trigger_grps (
    `sched_name` varchar(120)  not null comment '计划名称',
    `trigger_group` varchar(200)  not null comment '触发器组',
    primary key (sched_name,trigger_group)
) engine=innodb default charset=utf8 comment '存放暂停掉的触发器表';

-- 3、 调度器状态表
create table qrtz_scheduler_state (
    `sched_name` varchar(120)  not null comment '计划名称',
    `instance_name` varchar(200)  not null comment '实例名称',
    `last_checkin_time` bigint(13) not null comment '最后的检查时间',
    `checkin_interval` bigint(13) not null comment '检查间隔',
    primary key (sched_name,instance_name)
) engine=innodb default charset=utf8 comment '调度器状态表';

-- 4、 存储程序的悲观锁的信息(假如使用了悲观锁)
create table qrtz_locks (
    `sched_name` varchar(120)  not null comment '计划名称',
    `lock_name` varchar(40)  not null comment '锁名称',
    primary key (sched_name,lock_name)
) engine=innodb default charset=utf8 comment '存储程序的悲观锁的信息(假如使用了悲观锁) ';

-- 5、job 详细信息表
create table `qrtz_job_details`  (
  `sched_name` varchar(120)  not null comment '计划名称',
  `job_name` varchar(200)  not null comment '作业名称',
  `job_group` varchar(200)  not null comment '作业组',
  `description` varchar(250)   default null comment '描述',
  `job_class_name` varchar(250)  not null comment '作业程序类名',
  `is_durable` varchar(1)  not null comment '是否持久',
  `is_nonconcurrent` varchar(1)  not null comment '是否并行',
  `is_update_data` varchar(1)  not null comment '是否更新',
  `requests_recovery` varchar(1)  not null comment '是否要求唤醒',
  `job_data` blob null    comment '作业名称',
  primary key (`sched_name`, `job_name`, `job_group`)
) engine = innodb default charset=utf8 comment = 'job 详细信息表';

-- 6、 触发器表
create table qrtz_triggers (
    `sched_name` varchar(120)  not null comment '计划名称',
    `trigger_name` varchar(200)  not null comment '触发器名称',
    `trigger_group` varchar(200)  not null comment '触发器组',
    `job_name` varchar(200)  not null comment '作业名称',
    `job_group` varchar(200)  not null comment '作业组',
    `description` varchar(250)   default null comment '描述',
    `next_fire_time` bigint(13)  default null comment '下次执行时间',
    `prev_fire_time` bigint(13)  default null comment '前一次',
    `priority` int(11)  default null comment '优先权',
    `trigger_state` varchar(16)  not null comment '触发器状态',
    `trigger_type` varchar(8)  not null comment '触发器类型',
    `start_time` bigint(13) not null comment '开始时间',
    `end_time` bigint(13)  default null comment '结束时间',
    `calendar_name` varchar(200)   default null comment '日历名称',
    `misfire_instr` smallint(2)  default null comment '失败次数',
    `job_data` blob  null comment '作业数据',
    primary key (sched_name,trigger_name,trigger_group),
    foreign key (sched_name,job_name,job_group) references qrtz_job_details(sched_name,job_name,job_group)
) engine=innodb default charset=utf8 comment '触发器表';


-- 7、 简单的触发器表，包括重复次数，间隔，以及已触发的次数
create table qrtz_simple_triggers (
    `sched_name` varchar(120)  not null comment '计划名称',
    `trigger_name` varchar(200)  not null comment '触发器名称',
    `trigger_group` varchar(200)  not null comment '触发器组',
    `repeat_count` bigint(7) not null comment '重复次数',
    `repeat_interval` bigint(12) not null comment '重复间隔',
    `times_triggered` bigint(10) not null comment '触发次数',
    primary key (sched_name,trigger_name,trigger_group),
    foreign key (sched_name,trigger_name,trigger_group) references qrtz_triggers(sched_name,trigger_name,trigger_group)
) engine=innodb default charset=utf8 comment '简单的触发器表';


-- 8、 存储calendarintervaltrigger和dailytimeintervaltrigger两种类型的触发器
create table qrtz_simprop_triggers (
    `sched_name` varchar(120)  not null comment '计划名称',
    `trigger_name` varchar(200)  not null comment '触发器名称',
    `trigger_group` varchar(200)  not null comment '触发器组',
    `str_prop_1` varchar(512)  null default null comment '计划名称',
    `str_prop_2` varchar(512)  null default null comment '计划名称',
    `str_prop_3` varchar(512)  null default null comment '计划名称',
    `int_prop_1` int(11)  default null,
    `int_prop_2` int(11)  default null,
    `long_prop_1` bigint(20)  default null,
    `long_prop_2` bigint(20)  default null,
    `dec_prop_1` decimal(13, 4)  default null,
    `dec_prop_2` decimal(13, 4)  default null,
    `bool_prop_1` varchar(1)   default null,
    `bool_prop_2` varchar(1)   default null,
    primary key (sched_name,trigger_name,trigger_group),
    foreign key (sched_name,trigger_name,trigger_group) references qrtz_triggers(sched_name,trigger_name,trigger_group)
) engine=innodb default charset=utf8 comment '存储两种类型的触发器表';

-- 9、 定时触发器表，存储 cron trigger，包括 cron 表达式和时区信息
create table qrtz_cron_triggers (
    `sched_name` varchar(120)  not null comment '计划名称',
    `trigger_name` varchar(200)  not null comment '触发器名称',
    `trigger_group` varchar(200)  not null comment '触发器组',
    `cron_expression` varchar(120)  not null comment '时间表达式',
    `time_zone_id` varchar(80)  null default null comment '时区id',
    primary key (sched_name,trigger_name,trigger_group),
    foreign key (sched_name,trigger_name,trigger_group) references qrtz_triggers(sched_name,trigger_name,trigger_group)
) engine=innodb default charset=utf8 comment = '定时触发器表';

-- 10、 以blob 类型存储的触发器
create table qrtz_blob_triggers (
    `sched_name` varchar(120)  not null comment '计划名',
    `trigger_name` varchar(200)  not null comment '触发器名称',
    `trigger_group` varchar(200)  not null  comment '触发器组',
    `blob_data` blob null,
    primary key (sched_name,trigger_name,trigger_group),
    foreign key (sched_name,trigger_name,trigger_group) references qrtz_triggers(sched_name,trigger_name,trigger_group),
    KEY (sched_name)
) engine=innodb default charset=utf8 comment = '以blob 类型存储的触发器';


-- 11、 日历信息表， quartz可配置一个日历来指定一个时间范围
create table qrtz_calendars (
    `sched_name` varchar(120)  not null comment '计划名称',
    `calendar_name` varchar(200)  not null ,
    `calendar` blob not null,
    primary key (sched_name,calendar_name)
) engine=innodb default charset=utf8 comment = '日历信息表';


create index idx_qrtz_j_req_recovery on qrtz_job_details(sched_name,requests_recovery);
create index idx_qrtz_j_grp on qrtz_job_details(sched_name,job_group);

create index idx_qrtz_t_j on qrtz_triggers(sched_name,job_name,job_group);
create index idx_qrtz_t_jg on qrtz_triggers(sched_name,job_group);
create index idx_qrtz_t_c on qrtz_triggers(sched_name,calendar_name);
create index idx_qrtz_t_g on qrtz_triggers(sched_name,trigger_group);
create index idx_qrtz_t_state on qrtz_triggers(sched_name,trigger_state);
create index idx_qrtz_t_n_state on qrtz_triggers(sched_name,trigger_name,trigger_group,trigger_state);
create index idx_qrtz_t_n_g_state on qrtz_triggers(sched_name,trigger_group,trigger_state);
create index idx_qrtz_t_next_fire_time on qrtz_triggers(sched_name,next_fire_time);
create index idx_qrtz_t_nft_st on qrtz_triggers(sched_name,trigger_state,next_fire_time);
create index idx_qrtz_t_nft_misfire on qrtz_triggers(sched_name,misfire_instr,next_fire_time);
create index idx_qrtz_t_nft_st_misfire on qrtz_triggers(sched_name,misfire_instr,next_fire_time,trigger_state);
create index idx_qrtz_t_nft_st_misfire_grp on qrtz_triggers(sched_name,misfire_instr,next_fire_time,trigger_group,trigger_state);

create index idx_qrtz_ft_trig_inst_name on qrtz_fired_triggers(sched_name,instance_name);
create index idx_qrtz_ft_inst_job_req_rcvry on qrtz_fired_triggers(sched_name,instance_name,requests_recovery);
create index idx_qrtz_ft_j_g on qrtz_fired_triggers(sched_name,job_name,job_group);
create index idx_qrtz_ft_jg on qrtz_fired_triggers(sched_name,job_group);
create index idx_qrtz_ft_t_g on qrtz_fired_triggers(sched_name,trigger_name,trigger_group);
create index idx_qrtz_ft_tg on qrtz_fired_triggers(sched_name,trigger_group);

commit;

~~~