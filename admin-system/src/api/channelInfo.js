import request from '@/utils/request'

export function add(data) {
  return request({
    url: 'api/channelInfo',
    method: 'post',
    data
  })
}

export function del(id) {
  return request({
    url: 'api/channelInfo/' + id,
    method: 'delete'
  })
}

export function edit(data) {
  return request({
    url: 'api/channelInfo',
    method: 'put',
    data
  })
}
