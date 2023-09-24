
# Welcome to Danang Land 
  Dannang land là project để thực hiện công việc mua bán nhà dựa trên khu vực mà khách hàng muốn mua , từ đó có thể biết được giá tiền trung bình của khu vực .
   - về chức năng
     + admin có thể thêm sửa xóa cập nhật khu vực (quận) và giá trung bình của khu vực dó .
     + admin có thể quản lý vè lịch sử sreach theo giá của use.
     + user có thể xem thông tin giá của tất cả khu vực và có thể serach  theo giá tiền mình muốn

## install
- jdk 11
- Spring 2.7.16
- Maven : 4.0.0
- MySql

## IDE 
-Eclipse

## Run-Project
 - clone project
 - Run eclipse  => import folder => run with với spring boot
## Data
 - test-spring\sql\danang-home.sql

## Follow Code
- Tạo model thực thể mô tả về Quận , nhà và lịch sử mô tả trong dự án 
- sử dụng deFlag như một status để xóa 
- Tạo CRUD cho khu vực và nhà .
- khi admin thêm  thông tin nhà thì phải tìm khu vực(quận)đã tạo giá trung bình để tính giá nhà phù hợp với quận đó .
- Admin có thể quản lý thông tin lịch sử search của use , nhưng khi user serach có data mới lưu vào lịch sử search 
## API
- District
    + GET http://localhost:8089/api/district
    + POST http://localhost:8089/api/district/add
    + PUT http://localhost:8089/api/district/update
    + PUT http://localhost:8089/api/district/delete
- Home
    + GET http://localhost:8089/api/home
    + POST http://localhost:8089/api/home/add
    + PUT http://localhost:8089/api/home/update
    + PUT http://localhost:8089/api/home/delete

 - History
    + GET http://localhost:8089/api/history

## Author
Ho Quang Tan

