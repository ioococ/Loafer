var img = [
    'https://pic4.zhimg.com/v2-56fb75a1cf6688619522fa84e555a047_r.jpg',
    'http://h2.ioliu.cn/bing/TheWave_ZH-CN4856809836_1920x1080.jpg?imageslim',
    'https://pic1.zhimg.com/v2-743c8cb48a895234f81ac32b43795662_r.jpg',
    'https://pic3.zhimg.com/v2-c605f1427336e58b16a58e4260c830af_r.jpg',
    'https://pica.zhimg.com/v2-156f0b9d71227e141fa38223c6749b6b_r.jpg',
    'https://pic1.zhimg.com/v2-dd2250e66141d5db653c48f2b5463def_r.jpg'
]

function name() {
    // var z = -1;
    // var list = []
    // for (i = 0; i <= img.length; i++) {
    //     z = z + 1;
    //     getBase64(img[z])
    // }
    // function getBase64(imgUrl) {
    //     window.URL = window.URL || window.webkitURL;
    //     var xhr = new XMLHttpRequest();
    //     xhr.open("GET", imgUrl, true);
    //     // 至关重要
    //     xhr.responseType = "blob";
    //     xhr.onload = function () {
    //         if (this.status == 200) {
    //             //得到一个blob对象

    //             var blob = this.response;
    //             // console.log("blob", blob)
    //             //  至关重要
    //             let oFileReader = new FileReader();
    //             oFileReader.onloadend = function (e) {
    //                 let base64 = e.target.result;

    //                 // console.log("方式一》》》》》》》》》", base64)
    //                 list.push(base64)
    //                 // setInterval(function () { getImage() }, 10000);
    //                 // function getImage() {
    //                 //     document.getElementById("Pic").style.backgroundImage = "url('" + base64 + "'";
    //                 //     Pic.style.setProperty('--base64', base64)
    //                 // }
    //                 window.onload = getImage()
    //             };
    //             oFileReader.readAsDataURL(blob);
    //         }
    //     }
    //     xhr.send(null);
    // }
}
//图像刷新间隔 (毫秒)
setInterval(function () { getImage() }, 10000);
function getImage() {
    var imgUrl = Math.floor(Math.random() * (img.length - 1));
    document.getElementById("Pic").style.backgroundImage = "url('" + img[imgUrl] + "')";
}
window.onload = function () {
    setTimeout(function () {
        document.getElementById('Pic')['style']['opacity'] = '1'
        document.getElementById('titleTime')['style']['opacity'] = '1'
        document.getElementById('hitokoto')['style']['opacity'] = '1'
        document.getElementById('Swit')['style']['opacity'] = '1'
    }, 500)
}