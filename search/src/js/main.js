//建站时间
var first = new Date("11/18/2020");
var str = "本网站自2020年11月18日起已建站运行";
var now = new Date();
var ile = now.getTime() - first.getTime();
var days = Math.floor(ile / (1000 * 60 * 60 * 24));
console.log(str + days + "天");

setInterval(function () {
    putTime();
});

function putTime() {
    var getHor = new Date().getHours();
    var getMin = new Date().getMinutes();
    var getSec = new Date().getSeconds();

    //补零
    var minZero = 0
    var secZero = 0
    var horZero = 0
    if (getMin < 10) {
        minZero = '0'
    } else {
        minZero = ''
    }
    if (getSec < 10) {
        secZero = '0'
    } else {
        secZero = ''
    }
    if (getHor < 10) {
        horZero = '0'
    } else {
        horZero = ''
    }
    //字符串拼接
    var totalTime = horZero + getHor + ":" + minZero + getMin;
    document.getElementById('Time').innerHTML = totalTime
    document.getElementById('weekTime').innerHTML = "星期" + "日一二三四五六".charAt(new Date().getDay())
    document.getElementById('secondTime').innerHTML = secZero + getSec
}
function id(name) {
    return document.getElementById(name)
}
function css1(array, obj) {
    for (var i = 0; i < array.length; i++) {
        for (var r in obj) array[i].style.setProperty(r, obj[r])
    }

}
$(document).ready(function () {
    showQuote()
    getImage()
    document.getElementById('seEng').onclick = function () {
        id('Swit').style.display = 'flex'
        id('hitokoto').style.display = ''
        // id("Pic").style.filter = "blur(10px)" + " " + "brightness(var(--brightness))";
        id("Pic").style.filter = "blur(10px)";
        id("Pic").style.transform = "scale(1.1, 1.1)";
        id("Pic").style.transition = "0.25s";
        setTimeout(function () {
            css1([id('hitokoto'), id('Swit')], { 'opacity': '1' })
        }, 10)
        // id('seEng').style.width='380px'
        id('seEng').classList.add('open')
        // document.getElementsByClassName('dialog')[0].style.display = 'none'
    }
    document.getElementById('Pic').onclick = function () {
        // id("Pic").style.filter = "blur(0px)" + " " + "brightness(var(--brightness))";
        id("Pic").style.filter = "blur(0px)";
        id("Pic").style.transform = "scale(1, 1)";
        id("Pic").style.transition = "0.25s";
        css1([id('hitokoto'), id('Swit')], { 'opacity': '0' })
        setTimeout(function () {
            css1([id('Swit'), id('hitokoto')], { 'display': 'none' })
        }, 500)
        // id('seEng').style.width='300px'
        id('seEng').classList.remove('open')
        // document.getElementsByClassName('dialog')[0].style.display = 'none'
    }
})

function showQuote() {
    fetch('https://v1.hitokoto.cn/')
        .then(response => response.json())
        .then(data => {
            const hitokoto = document.getElementById('quoteContent')
            hitokoto.href = 'https://hitokoto.cn/?uuid=' + data.uuid
            hitokoto.innerText = data.hitokoto

            const from = document.getElementById('quoteOrigin')
            from.href = 'https://hitokoto.cn/?uuid=' + data.uuid
            from.innerText = data.from

            const author = document.getElementById('quoteSource')
            author.href = 'https://hitokoto.cn/?uuid=' + data.uuid
            author.innerText = data.author

            if (data.author == null) {
                document.getElementById('quoteAuthor').style.opacity = "0";
            } else {
                document.getElementById('quoteAuthor').style.opacity = "1";
            }
        })
        .catch(console.error)
}

function css(dom, obj) {
    for (var i in obj) dom.style.setProperty(i, obj[i])
}

var seEng;
var li = ["https://www.baidu.com/s?wd=", "https://cn.bing.com/search?q=", "https://www.google.com/search?q="]
var cf = document.getElementsByClassName('btn')
Array.from(cf).forEach(function (value, index, array) {
    value.onclick = function () {
        seEng = li[index]
        Array.from(cf).forEach(function (val, ind, array) {
            css(val, {
                "background-color": "var(--w-alpha-10)"
            })
        })
        css(value, {
            "background-color": "var(--w-alpha-30)"
        })
    }
})
$('#seEng').bind('keydown', function (event) {
    if (event.keyCode == "13") {
        var input = document.getElementById("seEng").value
        console.log(input);
        window.open(seEng + input + "&ie=utf-8&tn=ace")
    }
});
$(function () { $('#Swit-baidu').click(); });

//一言刷新间隔
setInterval(function () { showQuote() }, 10000);
var refresh = document.getElementsByClassName('quoteRefresh')[0]
refresh.onclick = function () {
    setTimeout(function () {
        showQuote()
    }, 400)
    css1([id('hitokoto')], { 'opacity': '0' }) //idh-hitokoto
    setTimeout(function () {
        css1([id('hitokoto')], { 'opacity': '1' })//idh-hitokoto
    }, 800)
}
if (window.matchMedia('prefers-color-scheme: light').matches) {
    refresh.onmousedown = function () {
        document.getElementsByClassName('quoteRefresh')[0].style.backgroundColor = 'var(--w-alpha-30)'
    }
    refresh.onmouseup = function () {
        setTimeout(function () {
            document.getElementsByClassName('quoteRefresh')[0].style.backgroundColor = 'var(--w-alpha-10)'
        }, 300)
    }
} else if (window.matchMedia('prefers-color-scheme: dark').matches) {
    refresh.onmousedown = function () {
        document.getElementsByClassName('quoteRefresh')[0].style.backgroundColor = 'var(--b-alpha-30)'
    }
    refresh.onmouseup = function () {
        setTimeout(function () {
            document.getElementsByClassName('quoteRefresh')[0].style.backgroundColor = 'var(--b-alpha-10)'
        }, 300)
    }
}


// 获取所有按钮
let bts = document.querySelectorAll('.button-left');
// 循环所有按钮
for (const key in bts) {
    if (bts.hasOwnProperty(key)) {
        const bt = bts[key];
        // 增加点击事件监听
        bt.addEventListener('click', () => {
            // 切换打开样式
            bt.classList.toggle('open');
            // document.getElementsByClassName('left-nr')[0].style.opacity='1'
            $(".left-nr").toggle();
            if (document.getElementsByClassName('left-nr')[0].style.display == 'none') {
                document.getElementsByClassName('left-nr')[0].style.display = ''
                setTimeout(function () {
                    document.getElementsByClassName('left-nr')[0].style.display = 'none'
                }, 500)
            } else {
                // document.getElementsByClassName('left-nr')[0].style=''
                document.getElementsByClassName('left-nr')[0].style.display = ''
            }
            document.getElementsByClassName('left-nr')[0].classList.toggle('open');
        });
    }
}

var idhitokoto = document.getElementById('hitokoto') //idh-hitokoto
idhitokoto.onmouseover = function () {
    document.getElementsByClassName('quoteBg')[0].style.opacity = "1"
    // document.getElementsByClassName('quoteBg')[0].style.filter = "blur(5px)"
}
idhitokoto.onmouseout = function () {
    document.getElementsByClassName('quoteBg')[0].style.opacity = "0"
    // document.getElementsByClassName('quoteBg')[0].style.filter = "blur(0px)"
}