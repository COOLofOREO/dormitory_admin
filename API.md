---
title: dormitory_admin v1.0.0
language_tabs:
  - shell: Shell
  - http: HTTP
  - javascript: JavaScript
  - ruby: Ruby
  - python: Python
  - php: PHP
  - java: Java
  - go: Go
toc_footers: []
includes: []
search: true
code_clipboard: true
highlight_theme: darkula
headingLevel: 2
generator: "@tarslib/widdershins v4.0.17"

---

# dormitory_admin

> v1.0.0

Base URLs:

* <a href="http://dev-cn.your-api-server.com">开发环境: http://dev-cn.your-api-server.com</a>

# 用户

## POST 用户登录

POST /userAll/login

可用邮箱输入密码登录，也可以邮箱发送验证码登录

> Body 请求参数

```json
{
  "email": "xxxxx@xxx.xxx",
  "password": "",
  "verificationId": "1001",
  "verification": "abcd"
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|loginWay|query|string| 是 ||登录方式 0：表示密码登录   1：表示验证码登录|
|body|body|object| 否 ||none|
|» email|body|string| 是 | 邮箱|none|
|» password|body|string| 否 | 密码|密码和验证码必须有一个必须填|
|» verification|body|string| 否 | 邮箱验证码|none|
|» verificationId|body|string| 否 | 验证码id|none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## POST 用户注册

POST /userAll/register

> Body 请求参数

```json
{
  "email": "string",
  "password": "string",
  "username": "string",
  "name": "string",
  "sex": "string",
  "age": 0,
  "phone": "string",
  "role": "string"
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|body|body|object| 否 ||none|
|» email|body|string| 是 | 注册邮箱|none|
|» password|body|string| 是 | 密码|none|
|» username|body|string| 是 | 用户名|none|
|» name|body|string| 是 | 姓名|none|
|» sex|body|string| 是 | 性别|none|
|» age|body|integer| 是 | 年龄|none|
|» phone|body|string| 是 | 电话号码|none|
|» role|body|string| 是 | 角色|学生/宿管/系统管理员|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## POST 用户信息修改

POST /userAll/upd

根据用户Id修改基本用户信息

> Body 请求参数

```json
{
  "userId": "string",
  "username": "string",
  "name": "string",
  "sex": "string",
  "age": "string",
  "phone": "string",
  "password": "string"
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|body|body|object| 否 ||none|
|» userId|body|string| 是 ||none|
|» username|body|string| 否 ||none|
|» name|body|string| 否 ||none|
|» sex|body|string| 否 ||none|
|» age|body|string| 否 ||none|
|» phone|body|string| 否 ||none|
|» password|body|string| 否 ||none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## DELETE 用户注销

DELETE /userAll/del

用户注销需输入其邮箱与密码

> Body 请求参数

```json
{
  "userId": "string",
  "email": "string",
  "password": "string"
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|body|body|object| 否 ||none|
|» userId|body|string| 是 ||none|
|» email|body|string| 是 ||none|
|» password|body|string| 是 ||none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

# 通用

## GET 发送验证码

GET /common/verification

向邮箱发送验证码，用户用验证码登录时需先调用此接口

> Body 请求参数

```json
{
  "email": "string"
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|body|body|object| 否 ||none|
|» email|body|string| 是 | 邮箱|none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

# 学生

## POST 学生信息填写

POST /student/add

> Body 请求参数

```json
{
  "userId": "string",
  "studentId": "string",
  "college": "string",
  "clazz": "string",
  "dormBuilding": "string",
  "dormNumber": "string"
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|body|body|object| 否 ||none|
|» userId|body|string| 是 | 用户id|none|
|» studentId|body|string| 是 | 学号|none|
|» college|body|string| 是 | 学院|none|
|» clazz|body|string| 是 | 班级|为避免关键字，所以用变量“clazz”表示|
|» dormBuilding|body|string| 否 | 宿舍楼栋号|有则填，非必须|
|» dormNumber|body|string| 否 | 寝室号|有则填，非必须|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## POST 学生信息修改

POST /student/upd

> Body 请求参数

```json
{
  "userId": "string",
  "studentId": "string",
  "college": "string",
  "grade": "string",
  "clazz": "string",
  "dormBuilding": "string",
  "dormNumber": "string",
  "authorityId": "string"
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|body|body|object| 否 ||none|
|» userId|body|string| 是 ||none|
|» studentId|body|string| 否 | 学号|none|
|» college|body|string| 否 | 学院|none|
|» grade|body|string| 否 | 年级|none|
|» clazz|body|string| 否 | 班级|none|
|» dormBuilding|body|string| 否 | 宿舍楼栋|none|
|» dormNumber|body|string| 否 | 寝室号|none|
|» authorityId|body|string| 否 | 权限|none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 获取学生权限

GET /student/authority

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|userId|query|string| 否 ||none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 获取学生信息

GET /student

> Body 请求参数

```json
{
  "userId": "string",
  "studentId": "string",
  "authorityId": "string"
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|body|body|object| 否 ||none|
|» userId|body|string| 是 ||none|
|» studentId|body|string| 是 ||none|
|» authorityId|body|string| 是 ||none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

# 系统管理员

## POST 管理员信息填写

POST /Administrator/add

> Body 请求参数

```json
{
  "userId": "string",
  "employeeId": "string"
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|body|body|object| 否 ||none|
|» userId|body|string| 是 ||none|
|» employeeId|body|string| 是 | 职工号|none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## POST 管理员信息修改

POST /Administrator/upd

修改职工号

> Body 请求参数

```json
{
  "userId": "string",
  "employeeId": "string"
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|body|body|object| 否 ||none|
|» userId|body|string| 是 ||none|
|» employeeId|body|string| 否 | 职工号|none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## POST 新增权限

POST /Administrator/authority/add

新增权限

> Body 请求参数

```json
{
  "userId": "string",
  "publishClock": true,
  "updateClock": true,
  "studentRead": true,
  "studentWrite": true,
  "housemasterRead": true,
  "housemasterWrite": true,
  "noticeRead": true,
  "noticeWrite": true
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|body|body|object| 否 ||none|
|» userId|body|string| 是 ||none|
|» publishClock|body|boolean| 是 | 能否发布打卡|none|
|» updateClock|body|boolean| 是 | 能否更新打卡|none|
|» studentRead|body|boolean| 是 | 能否读学生信息|none|
|» studentWrite|body|boolean| 是 | 能否写学生信息|none|
|» housemasterRead|body|boolean| 是 | 能否读宿管信息|none|
|» housemasterWrite|body|boolean| 是 | 能否写宿管信息|none|
|» noticeRead|body|boolean| 是 | 能否读公告|none|
|» noticeWrite|body|boolean| 是 | 能否写公告信息|none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## DELETE 删除权限

DELETE /Administrator/authority/del

> Body 请求参数

```json
{
  "userId": "string",
  "authorityId": "string"
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|body|body|object| 否 ||none|
|» userId|body|string| 是 ||none|
|» authorityId|body|string| 是 | 权限编号|none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## POST 更新权限

POST /Administrator/authority/upd

> Body 请求参数

```json
{
  "userId": "string",
  "authorityId": "string",
  "publishClock": true,
  "updateClock": true,
  "studentRead": true,
  "studentWrite": true,
  "housemasterRead": true,
  "housemasterWrite": true,
  "noticeRead": true,
  "noticeWrite": true
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|body|body|object| 否 ||none|
|» userId|body|string| 是 ||none|
|» authorityId|body|string| 是 | 权限编号|none|
|» publishClock|body|boolean| 否 ||none|
|» updateClock|body|boolean| 否 ||none|
|» studentRead|body|boolean| 否 ||none|
|» studentWrite|body|boolean| 否 ||none|
|» housemasterRead|body|boolean| 否 ||none|
|» housemasterWrite|body|boolean| 否 ||none|
|» noticeRead|body|boolean| 否 ||none|
|» noticeWrite|body|boolean| 否 ||none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 获取管理员信息

GET /Administrator

> Body 请求参数

```json
{
  "userId": "string"
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|body|body|object| 否 ||none|
|» userId|body|string| 是 ||none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

# 宿舍管理员

## POST 宿管信息填写

POST /housemaster/add

> Body 请求参数

```json
{
  "userId": "string",
  "employeeId": "string",
  "dormBuilding": "string"
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|body|body|object| 否 ||none|
|» userId|body|string| 是 ||none|
|» employeeId|body|string| 是 | 职工号|none|
|» dormBuilding|body|string| 否 | 管理楼栋|有则填|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## POST 宿管信息修改

POST /housemaster/upd

宿管信息修改

> Body 请求参数

```json
{
  "userId": "string",
  "employeeId": "string",
  "dormBuilding": "string",
  "authorityId": "string"
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|body|body|object| 否 ||none|
|» userId|body|string| 是 ||none|
|» employeeId|body|string| 否 ||none|
|» dormBuilding|body|string| 否 | 管理楼栋|none|
|» authorityId|body|string| 否 | 权限代号|none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 获取宿管信息

GET /housemaster

> Body 请求参数

```json
{
  "userId": "string",
  "employeeId": "string"
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|body|body|object| 否 ||none|
|» userId|body|string| 是 ||none|
|» employeeId|body|string| 是 | 职工号|none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

# 考勤

## POST 新增考勤

POST /clockIn/add

> Body 请求参数

```json
{
  "userId": "string",
  "beginTime": "string",
  "endTime": "string",
  "reparable": true
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|body|body|object| 否 ||none|
|» userId|body|string| 是 ||none|
|» beginTime|body|string| 是 | 开始时间|none|
|» endTime|body|string| 是 | 结束时间|none|
|» reparable|body|boolean| 是 | 能否补签|none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## POST 修改考勤

POST /clockIn/upd

> Body 请求参数

```json
{
  "userId": "string",
  "beginTime": "string",
  "endTime": "string",
  "reparable": true
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|body|body|object| 否 ||none|
|» userId|body|string| 是 ||none|
|» beginTime|body|string| 否 | 开始时间|none|
|» endTime|body|string| 否 | 结束时间|none|
|» reparable|body|boolean| 否 | 能否补签|none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 获取指定考勤

GET /clockIn/get

获取指定用户已发布的全部考勤

> Body 请求参数

```json
{
  "userId": "string"
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|body|body|object| 否 ||none|
|» userId|body|string| 是 ||none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 获取全部考勤

GET /clockIn

获取已发布的全部考勤

> Body 请求参数

```json
{
  "userId": "string"
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|body|body|object| 否 ||none|
|» userId|body|string| 是 ||none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

# 公告

## POST 发布公告

POST /notice/add

> Body 请求参数

```json
{
  "userid": "string",
  "title": "string",
  "content": "string",
  "beginTime": "string",
  "endTime": "string"
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|body|body|object| 否 ||none|
|» userid|body|string| 是 ||none|
|» title|body|string| 是 | 标题|none|
|» content|body|string| 是 | 内容|none|
|» beginTime|body|string| 是 | 发布时间|none|
|» endTime|body|string| 否 | 结束时间|none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 获取公告

GET /notice

> Body 请求参数

```json
{
  "userId": "string"
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|body|body|object| 否 ||none|
|» userId|body|string| 是 ||none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## POST 修改公告

POST /notice/upd

> Body 请求参数

```json
{
  "userId": "string",
  "noticeId": "string",
  "title": "string",
  "content": "string"
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|body|body|object| 否 ||none|
|» userId|body|string| 是 ||none|
|» noticeId|body|string| 是 | 公告id|none|
|» title|body|string| 否 | 标题|none|
|» content|body|string| 否 | 内容|none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

# 数据模型

<h2 id="tocS_Tag">Tag</h2>

<a id="schematag"></a>
<a id="schema_Tag"></a>
<a id="tocStag"></a>
<a id="tocstag"></a>

```json
{
  "id": 1,
  "name": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer(int64)|false|none||标签ID编号|
|name|string|false|none||标签名称|

<h2 id="tocS_Category">Category</h2>

<a id="schemacategory"></a>
<a id="schema_Category"></a>
<a id="tocScategory"></a>
<a id="tocscategory"></a>

```json
{
  "id": 1,
  "name": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer(int64)|false|none||分组ID编号|
|name|string|false|none||分组名称|

<h2 id="tocS_Pet">Pet</h2>

<a id="schemapet"></a>
<a id="schema_Pet"></a>
<a id="tocSpet"></a>
<a id="tocspet"></a>

```json
{
  "id": 1,
  "category": {
    "id": 1,
    "name": "string"
  },
  "name": "doggie",
  "photoUrls": [
    "string"
  ],
  "tags": [
    {
      "id": 1,
      "name": "string"
    }
  ],
  "status": "available"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer(int64)|true|none||宠物ID编号|
|category|[Category](#schemacategory)|true|none||分组|
|name|string|true|none||名称|
|photoUrls|[string]|true|none||照片URL|
|tags|[[Tag](#schematag)]|true|none||标签|
|status|string|true|none||宠物销售状态|

#### 枚举值

|属性|值|
|---|---|
|status|available|
|status|pending|
|status|sold|

