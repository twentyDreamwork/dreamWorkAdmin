import request from '@/utils/request'

export function add(data) {
  return request({
    url: 'api/userInfo',
    method: 'post',
    data
  })
}

export function del(id) {
  return request({
    url: 'api/userInfo/' + id,
    method: 'delete'
  })
}

export function edit(data) {
  return request({
    url: 'api/userInfo',
    method: 'put',
    data
  })
}
