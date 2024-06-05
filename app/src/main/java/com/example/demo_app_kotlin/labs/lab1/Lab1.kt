package com.example.demo_app_kotlin.labs.lab1


class product(_id: Int, _name: String, _price: Int, _description: String) {
    var id: Int = 0
    var name: String = ""
    var price: Int = 0
    var description: String = ""
    init {
        this.id = _id
        this.name = _name
        this.price = _price
        this.description = _description
    }
}

var listProducts = mutableListOf(
    product(1, "banh", 1000, "abc"),
    product(2, "banh", 1000, "abc"),
    product(3, "banh", 1000, "abc"),
    product(4, "banh", 1000, "abc")
)

fun main(){
    chooseFuntion()
}


fun printListProducts() {
    println("Danh sách sản phẩm: ")
    for (product in listProducts){
        println("id: ${product.id}, name: ${product.name}, price: ${product.price}, desciption: ${product.description}")
    }
}


fun detailToId(){
    print("Nhập id cần tìm: ")
    var id = readln().toInt()
    var check  = false
    for (product in listProducts){
        if (product.id == id){
            println( "chi tiết sản phẩm: id: ${product.id}, name: ${product.name}, price: ${product.price}, desciption: ${product.description}")
            check = true
            break
        }
    }
    if (!check) println("Sản phẩm không tồn tại!")
}


fun addProduct(){
    val id = listProducts[listProducts.lastIndex].id + 1
    while (true){
        print("nhập tên sản phẩm: ")
        val name = readln()
        print("nhập giá sản phẩm: ")
        val price = readln()
        print("nhập mô tả sản phẩm: ")
        val description = readln()
        if (name.isNullOrEmpty() || price == null || description.isNullOrEmpty()) {
            println("Vui lòng nhập đầy đủ thông tin của sản phẩm!")
        }else{
            val product = product(id, name, price.toInt(), description)
            listProducts.add(product)
            println("Thêm sản phẩm thành công!")
            println("Danh sách sản phẩm mới: ")
            printListProducts()
            break
        }
    }

}

fun editProduct(){
    print("Nhập id cần sửa: ")
    val id = readln()?.toInt()
    var check = false
    for (product in listProducts){
        if (product.id == id){
            println("Sản phẩm hiện tại: id: ${product.id} - name: ${product.name} - price: ${product.price} - decription: ${product.description}")
            print("nhập tên sản phẩm: ")
            val name = readln()!!
            print("nhập giá sản phẩm: ")
            val price = readln()!!
            print("nhập mô tả sản phẩm: ")
            val description = readln()!!
            product.name = name
            product.price = price.toInt()
            product.description = description
            println("Cập nhật sản phẩm thành công!")
            println("Sản phẩm sau khi cập nhật: id: ${product.id} - name: ${product.name} - price: ${product.price} - decription: ${product.description}")
            check = true
            break
        }
    }
    if (!check) println("Sản phẩm không tồn tại")
}

fun deleteProduct(){
    print("Nhập id sản phẩm cẩn xóa ")
    val id = readln().toInt()
    if (listProducts.removeIf { it.id == id }) println("Xóa sản phẩm thành công") else println("Sản phẩm cần xóa không tồn lại!")
}

fun chooseFuntion(){
    while (true){
        println("--------------------------------")
        println("| Menu                         |")
        println("| 1: Xem list sản phẩm         |")
        println("| 2: Tìm sản phẩm theo id      |")
        println("| 3: Thêm sản phẩm             |")
        println("| 4: Sửa sản phẩm              |")
        println("| 5: Xóa sản phẩm              |")
        println("| 6: Thoát chương trình        |")
        println("--------------------------------")
          print(">> Vui lòng chọn chức năng: ")
        val number = readln()?.toIntOrNull()
        when(number){
            1 -> printListProducts()
            2 -> detailToId()
            3 -> addProduct()
            4 -> editProduct()
            5 -> deleteProduct()
            6 -> break
            else -> println("Lựa chọn không hợp lệ.")
        }
        println("")
    }
}



