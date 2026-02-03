require('dotenv').config();
const express = require('express');

const app = express();
const PORT = process.env.PORT || 3000;

// Updated User list route with refined usernames
app.get('/users', (req, res) => {
  const users = [
    { id: 1, username: 'zhangsan', realName: '张三', phone: '123-456-7890', avatar: '/src/img/hzl.jpg' },
    { id: 2, username: 'lisi', realName: '李四', phone: '987-654-3210', avatar: '/src/img/hzl.jpg' },
    { id: 3, username: 'wangwu', realName: '王五', phone: '555-666-7777', avatar: '/src/img/hzl.jpg' },
    { id: 4, username: 'zhaoliu', realName: '赵六', phone: '111-222-3333', avatar: '/src/img/hzl.jpg' },
    { id: 5, username: 'sunqi', realName: '孙七', phone: '444-555-6666', avatar: '/src/img/hzl.jpg' },
    { id: 6, username: 'zhouba', realName: '周八', phone: '777-888-9999', avatar: '/src/img/hzl.jpg' },
    { id: 7, username: 'chenjiu', realName: '陈九', phone: '888-999-0000', avatar: '/src/img/hzl.jpg' },
    { id: 8, username: 'huangshi', realName: '黄十', phone: '222-333-4444', avatar: '/src/img/hzl.jpg' },
    { id: 9, username: 'liangshi', realName: '梁十一', phone: '333-444-5555', avatar: '/src/img/hzl.jpg' },
    { id: 10, username: 'zhoushi', realName: '周十二', phone: '444-555-6666', avatar: '/src/img/hzl.jpg' },
    // { id: 11, username: 'wushi', realName: '吴十三', phone: '555-666-7777', avatar: '/src/img/hzl.jpg' },
    // { id: 12, username: 'zhangshi', realName: '张十四', phone: '666-777-8888', avatar: '/src/img/hzl.jpg' },
    // { id: 13, username: 'lishi', realName: '李十五', phone: '777-888-9999', avatar: '/src/img/hzl.jpg' },
    // { id: 14, username: 'wangshi', realName: '王十六', phone: '888-999-0000', avatar: '/src/img/hzl.jpg' },
    // { id: 15, username: 'zhaoshi', realName: '赵十七', phone: '999-000-1111', avatar: '/src/img/hzl.jpg' },
    // { id: 16, username: 'sunshi', realName: '孙十八', phone: '000-111-2222', avatar: '/src/img/hzl.jpg' },
    // { id: 17, username: 'liuhai', realName: '刘海', phone: '111-222-3333', avatar: '/src/img/hzl.jpg' },
    // { id: 18, username: 'zhangwei', realName: '张伟', phone: '222-333-4444', avatar: '/src/img/hzl.jpg' },
    // { id: 19, username: 'wanghong', realName: '王红', phone: '333-444-5555', avatar: '/src/img/hzl.jpg' },
    // { id: 20, username: 'zhaoyun', realName: '赵云', phone: '444-555-6666', avatar: '/src/img/hzl.jpg' },
    // { id: 21, username: 'sunli', realName: '孙丽', phone: '555-666-7777', avatar: '/src/img/hzl.jpg' },
    // { id: 22, username: 'zhouqiang', realName: '周强', phone: '666-777-8888', avatar: '/src/img/hzl.jpg' },
    // { id: 23, username: 'chenfeng', realName: '陈峰', phone: '777-888-9999', avatar: '/src/img/hzl.jpg' },
    // { id: 24, username: 'huangmei', realName: '黄梅', phone: '888-999-0000', avatar: '/src/img/hzl.jpg' },
    // { id: 25, username: 'liangyu', realName: '梁宇', phone: '999-000-1111', avatar: '/src/img/hzl.jpg' },
    // { id: 26, username: 'zhoushan', realName: '周山', phone: '000-111-2222', avatar: '/src/img/hzl.jpg' },
    // { id: 27, username: 'wuming', realName: '吴明', phone: '111-222-3333', avatar: '/src/img/hzl.jpg' },
    // { id: 28, username: 'zhangli', realName: '张丽', phone: '222-333-4444', avatar: '/src/img/hzl.jpg' },
    // { id: 29, username: 'lishan', realName: '李山', phone: '333-444-5555', avatar: '/src/img/hzl.jpg' },
    // { id: 30, username: 'wanglin', realName: '王林', phone: '444-555-6666', avatar: '/src/img/hzl.jpg' },
    // { id: 31, username: 'zhaofeng', realName: '赵峰', phone: '555-666-7777', avatar: '/src/img/hzl.jpg' },
    // { id: 32, username: 'sunyan', realName: '孙燕', phone: '666-777-8888', avatar: '/src/img/hzl.jpg' },
    // { id: 33, username: 'zhouyan', realName: '周艳', phone: '777-888-9999', avatar: '/src/img/hzl.jpg' },
    // { id: 34, username: 'chenyan', realName: '陈艳', phone: '888-999-0000', avatar: '/src/img/hzl.jpg' },
    // { id: 35, username: 'huangyan', realName: '黄燕', phone: '999-000-1111', avatar: '/src/img/hzl.jpg' },
    // { id: 36, username: 'liangyan', realName: '梁燕', phone: '000-111-2222', avatar: '/src/img/hzl.jpg' },
    // { id: 37, username: 'zhangyan', realName: '张燕', phone: '111-222-3333', avatar: '/src/img/hzl.jpg' },
    // { id: 38, username: 'liyan', realName: '李燕', phone: '222-333-4444', avatar: '/src/img/hzl.jpg' },
    // { id: 39, username: 'wangyan', realName: '王燕', phone: '333-444-5555', avatar: '/src/img/hzl.jpg' },
    // { id: 40, username: 'zhaoyan', realName: '赵燕', phone: '444-555-6666', avatar: '/src/img/hzl.jpg' },
    // { id: 41, username: 'sunyao', realName: '孙瑶', phone: '555-666-7777', avatar: '/src/img/hzl.jpg' },
    // { id: 42, username: 'zhouyao', realName: '周瑶', phone: '666-777-8888', avatar: '/src/img/hzl.jpg' },
    // { id: 43, username: 'chenyao', realName: '陈瑶', phone: '777-888-9999', avatar: '/src/img/hzl.jpg' },
    // { id: 44, username: 'huangyao', realName: '黄瑶', phone: '888-999-0000', avatar: '/src/img/hzl.jpg' }
  ];

  res.json(users);
});

app.listen(PORT, () => {
  console.log(`Server is running on http://localhost:${PORT}`);
});
