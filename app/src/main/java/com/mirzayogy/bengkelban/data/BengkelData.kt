package com.mirzayogy.bengkelban.data

import com.mirzayogy.bengkelban.model.Bengkel

object BengkelData {
    var data = arrayOf(
        arrayOf("1","Sahabat Bengkel","Paulus Iswan","https://mirzayogy.com/androidphp/gambur/Sahabat%20bengkel_Paulus%20iswan.jpg","YA","YA", "-3.4381748","114.7482626"),
        arrayOf("2","LCM (Lucas Motor)", "Lucas","https://mirzayogy.com/androidphp/gambur/LCM%20(Lukas%20Motor)_Lukas.jpg","TIDAK","YA","-3.434484","114.7428616"),
        arrayOf("3","Tambal Ban Herman", "Herman","https://mirzayogy.com/androidphp/gambur/Tambal%20Ban%20Herman_Herman.jpg","TIDAK","YA","-3.4413361","114.7397406"),
        arrayOf("4","Bengkel Dipta", "Syamsu Alamsyah","https://mirzayogy.com/androidphp/gambur/Bengkel%20Dipta_Syamsu%20Alamsyah.jpg","TIDAK","YA","-3.4211359","114.7493547"),
        arrayOf("5","Alif Motor", "Alif","https://mirzayogy.com/androidphp/gambur/ALIF%20MOTOR_BAPAK%20ALIF.jpg","YA","YA","-3.4365874","114.751507"),
        arrayOf("6","bengkel ari", "ari","https://mirzayogy.com/androidphp/gambur/bengkel%20ari_ari.jpg","YA","YA","-3.4620203","114.8184901"),
        arrayOf("7","AJM 74", "arief","https://mirzayogy.com/androidphp/gambur/AJM%2074_arief.jpg","TIDAK","YA","-3.4618144","114.8180979"),
        arrayOf("8","paladu bengkel", "eko manurung","https://mirzayogy.com/androidphp/gambur/gambur/paladu bengkel_eko manurung.jpg","TIDAK","YA","-3.4520727","114.8180468"),
        arrayOf("9","Mitra Buana Spareparts", "Mahyudin","https://mirzayogy.com/androidphp/gambur/Mitra Buana Spareparts_Mahyudin.jpg","TIDAK","YA","-3.4495883","114.831995"),
        arrayOf("10","bengkel habaladung", "eko manoro","https://mirzayogy.com/androidphp/gambur/bengkel habaladung_eko manoro.jpg","TIDAK","YA","-3.4520317","114.8180489"),
        arrayOf("11","Bengkel Syifa", "Bapak Juman","https://mirzayogy.com/androidphp/gambur/Bengkel Syifa_Bapak Juman.jpg","YA","YA","-3.4425067","114.8426417")

    )
    val listData: ArrayList<Bengkel>
        get() {
            val list = ArrayList<Bengkel>()
            for (aData in data) {
                val bengkel = Bengkel()
                bengkel.id = aData[0]
                bengkel.name = aData[1]
                bengkel.owner = aData[2]
                bengkel.photo = aData[3]
                bengkel.car = aData[4]
                bengkel.bike = aData[5]
                bengkel.lat = aData[6]
                bengkel.lng = aData[7]
                list.add(bengkel)
            }
            return list
        }
}