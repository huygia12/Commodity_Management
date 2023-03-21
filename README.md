# Java_project
DA_CNTT - Phần mềm quản lý mua bán hàng tạp hóa bằng JAVA

MEMBERS: Nguyen Gia Huy, Vu Hung Tung, Dao Van Tuyen, Nguyen Thao Chi

A.	GENERAL REQUIREMENTS: 

B.	DETAILS (DEMO ON CONSOLE):

I.	Project overview:

Goods
-goodsName(String)
-goodsID(String)
-provider(String)
-listPrice(int)
-totalQuantity(int)
-List<Shipment>	<1> getter(), setter(),…
<2> constructor() có tham số và không tham số(tham số: goodsName, provider, listPrice)

Shipment	
-expDate(date/time)
-proDate(date/time)
-quantity(int)
-importPrice(int)
-shipmentID(int)	
<1> getter(), setter()
<2> constructor() có tham số, không tham số(tham số: expDate, proDate, quantity, importPrice)

Repository	
-List<Goods>
	(Bao gồm cả đọc và ghi dữ liệu trong File)
<1> getter(), setter()
<2> constructor()
<3> addNewGoods() : thêm mới một sản phẩm 
<4> importGoods(): nhập hàng
<5> deleteAGoods(): xóa htoan một sản phẩm 
<6> changeGoodsInfor() : thay đổi thông tin sản phẩm ( goodsName, provider, listPrice)
<7> checkRepository() : lxxist all goods and it’sInfor
<8> searchGoods(): tìm kiếm sản phẩm
<9> filter(): lọc danh sách theo … 

Order	
-List<Goods>
-orderID(String)
-discount(int)	<1> getter(), setter()
<2> constructor()
<3> addToOrder() : thêm hàng vào order 
<4> deleteFromOrder(): xóa khỏi order
<5> totalPayment() : tổng giá trị order
<6> totalAfterDiscount(): giá trị order sau khi discount
<7> printOutBill(): xuất order (ra file)

Commodity Management		
<1> menuOfMainFunction() 
<2> menuOfRepoMangement()
<3> makeAnOrder()

II.	Detail Implementation:
1.	menuOfMainFuntion():
********************************
* 1. Repository Management     *
* 2. Make New Order            *
* 3. Current Revenue Overview  *
* 4. Exit                      * 
********************************
2.	menuOfRepoManagement():
************************************
* 1. Add New Goods                 *
* 2. Import Goods                  *
* 3. Change Goods||Shipment Infor  *
* 3. Delete Goods                  *
* 5. Show Repository               *
* 6. Make a filter                 *
* 7. Back                          *
************************************
3.	addNewGoods():
- Chức năng: thêm mới một sản phẩm, thực hiện set các thuộc tính(goodsName, listPrice, provider)
- Cách thức: tự động tạo ID,  người dùng nhập vào thông tin sản phẩm
4.	importGoods():
- Chức năng: nhập hàng, cập nhật số lượng, hạn sử dụng, ngày sản xuất, giá nhập.
- Cách thức: 
+ Người sử dụng tìm kiếm mặt hàng(theo tên hoặc ID) để cập nhật thông tin(hàng không tồn tại) 
+ Nếu là ID thì hiển thị luôn ra mặt hàng trong kho
+ Nếu là tên thì hiển thị danh sách các mặt hàng trùng tên với tên đã nhập, người dùng tham khảo danh sách rồi nhập theo một cú pháp định sẵn : 
Eg: goodsID 
+ Điền thông tin nhập hàng: hsd, nsx, soluong, tien. 
+ Nếu mà cùng hsd, nsx, tien thì cộng thêm so luong vào shipment đã có sẵn.
+Ghi hóa đơn nhập hàng lên file của ngày nhập hàng đó.
5.	deleteAGoods():
- Chức năng: xóa sản phẩm.
-  Cách thức: 
+ Người sử dụng tìm kiếm mặt hàng(theo tên hoặc ID) để cập nhật thông tin(hàng không tồn tại).
+ Nếu là ID thì hiển thị luôn ra mặt hàng trong kho.
+ Nếu là tên thì hiển thị danh sách các mặt hàng trùng tên với tên đã nhập, người dùng tham khảo danh sách rồi nhập theo một cú pháp định sẵn : 
Eg: goodsID 
+ Xóa.
*Lưu ý: Khi số lượng của shipment về 0(hoặc khi xóa sản phẩm) thì sẽ đặt thông tin của cái ID của shipment(goods)  về default. Khi nào nhập shipment(goods) mới thì duyệt rồi sử dụng lại ID đó. 
6.	changeGoodsInfor(shipments):
- Chức năng: thay đổi thông tin sản phẩm: nhà sản xuất, tên, giá bán.
- Cách thức: 
+ Người sử dụng tìm kiếm mặt hàng(theo tên hoặc ID) để cập nhật thông tin(hàng không tồn tại).
+ Nếu là ID thì hiển thị luôn ra mặt hàng trong kho.
+ Nếu là tên thì hiển thị danh sách các mặt hàng trùng tên với tên đã nhập, người dùng tham khảo danh sách rồi nhập theo một cú pháp định sẵn : 
Eg: goodsID 
+ Lưu ý: cảnh báo người dùng không được thay đổi thuộc tính nsx+ tên trùng hoàn toàn với 1 sản phẩm khác có sẵn trong list.
+ Thêm: sửa thông tin shipment của goods nhập.
7.	searchGood():
- Chức năng: tìm kiếm.
- Cách thức: 
- Cách thức: 
+ Người sử dụng tìm kiếm mặt hàng(theo tên hoặc ID) để cập nhật thông tin(hàng không tồn tại).
+ Nếu là ID thì hiển thị luôn ra mặt hàng trong kho.
+ Nếu là tên thì hiển thị danh sách các mặt hàng trùng tên với tên đã nhập, người dùng tham khảo danh sách rồi nhập theo một cú pháp định sẵn : 
Eg: goodsID 
8.	 filter(): 
****************************************************
*  1.Goods from the same manufacturer              *
*  2.Top10 least quantity goods in stock           *
*  3.Top10 largest quantity goods in stock         *
*  4.Top10 goods with most recent production date  *
*  5.Expired goods                                 *
*  6.Back                                          *
****************************************************
1.	So sánh tên nhà sản xuất nhập từ bàn phím với tên nhà  sản xuất của từng sản phẩm rồi hiện ra list.
2.	Sắp xếp danh sách theo số lượng tăng dần rồi lấy top 10.
3.	Như câu 2
4.	Sắp xếp danh sách theo ngày sản xuất giảm dần, rồi lấy top 10.
5.	Hiển thị danh sách sản phẩm quá hạn
9.	 addToOrder():
- Chức năng: thêm sản phẩm đã chọn vào bill, tăng số lượng theo ý người nhập.
- Cách thức: 
		+ Thực hiện tìm kiếm, sau khi chọn được sản phẩm thì thêm vào list
+ Sử dụng totalQuantity để lưu số lượng muốn mua.
+ Nếu mà trùng với sản phẩm chọn rồi thì đặt lại số lượng theo lần nhập mới nhất.
+ Nhập số lượng == 0 thì xóa khỏi order.
+ Mỗi lần add xong, hiển thị lại toàn bộ order hiện tại.
10.	 deleteFromOrder():
- Chức năng: xóa sản phẩm khỏi bill.
- Cách thức: dùng hàm của java. 
11.	 makeNewOrder():
- Chức năng: tạo một order mới để thực hiện chức năng thêm, xóa, thanh toán rồi in ra bill.
12.	 printOutBill(): 

III.	Advanced requirementS
- Sử dụng file để lưu trữ thông tin.
- Lọc thông tin lưu ra file riêng.
- Ưu tiên sử dụng json hoặc excel.
- Sử dụng file để xuất ra hóa đơn chốt ca cuối ngày(tiền nhập, tiền bán, doanh thu net…)
- Phát triển phần mềm giao diện (GUI)
- Thêm một số tính năng: 
	+ Register + login( account + password)
	+ Lưu vào dữ liệu vào file
	+ Xuất hóa đơn, báo cáo doanh thu ra file
- Thêm tính năng nâng cao: 
	+ khi gõ 1 số ký tự theo tenSP, sẽ lọc danh sách theo những ký tự đã nhập.
