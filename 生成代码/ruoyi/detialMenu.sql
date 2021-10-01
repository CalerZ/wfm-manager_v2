-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('wfm_detial', '3', '1', '/system/detial', 'C', '0', 'system:detial:view', '#', 'admin', sysdate(), '', null, 'wfm_detial菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('wfm_detial查询', @parentId, '1',  '#',  'F', '0', 'system:detial:list',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('wfm_detial新增', @parentId, '2',  '#',  'F', '0', 'system:detial:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('wfm_detial修改', @parentId, '3',  '#',  'F', '0', 'system:detial:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('wfm_detial删除', @parentId, '4',  '#',  'F', '0', 'system:detial:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('wfm_detial导出', @parentId, '5',  '#',  'F', '0', 'system:detial:export',       '#', 'admin', sysdate(), '', null, '');
