import request from '@/utils/request'

/**
* 新增数据
* @param item
*/
export function add(data) {
    return request({
        url: '/api/${moduleName}/${tableInfo.classNameLower}s/add',
        method: 'post',
        data: item
    })
}

/**
* 根据主键删除
*/
export function deleteByKey(id) {
    return request({
        url: '/api/${moduleName}/${tableInfo.classNameLower}s/' + id
        method: 'delete'
    })
}

/**
* 根据主键修改
* @param data
*/
export function update(data) {
    return request({
        url: '/api/${moduleName}/${tableInfo.classNameLower}s/update',
        method: 'put',
        data: data
    })
}

/**
* 根据主键查询实体
* @param id
*/
export function getByKey(id) {
    return request({
        url: '/api/${moduleName}/${tableInfo.classNameLower}s/' + id
        method: 'get'
    })
}

/**
* 条件查询获取列表，不带分页
* @param query
*/
export function getList(query) {
    return request({
        url: '/api/${moduleName}/${tableInfo.classNameLower}s/list',
        method: 'get',
        params: query
    })
}

/**
* 条件查询获取列表，带分页
* @param query
*/
export function getPage(query) {
    return request({
        url: '/api/${moduleName}/${tableInfo.classNameLower}s/page',
        method: 'get',
        params: query
    })
}