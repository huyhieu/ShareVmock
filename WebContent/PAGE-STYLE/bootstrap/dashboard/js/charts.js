var Charts = function () {
    return{initCharts: function () {
        function t() {
            for (c.length && (c = c.slice(1)); c.length < l;) {
                var t = c.length ? c[c.length - 1] : 50, e = t + 10 * Math.random() - 5;
                c.push(0 > e ? 0 : e > 100 ? 100 : e)
            }
            for (var i = [], n = 0; n < c.length; ++n)i.push([n, c[n]]);
            return i
        }

        function e() {
            for (var t = [], e = 0; e < 2 * Math.PI; e += .25)t.push([e, Math.sin(e)]);
            for (var i = [], e = 0; e < 2 * Math.PI; e += .25)i.push([e, Math.cos(e)]);
            for (var n = [], e = 0; e < 2 * Math.PI; e += .1)n.push([e, Math.tan(e)]);
            $.plot($("#chart_1"), [
                {label: "sin(x)", data: t},
                {label: "cos(x)", data: i},
                {label: "tan(x)", data: n}
            ], {series: {lines: {show: !0}, points: {show: !0}}, xaxis: {ticks: [0, [Math.PI / 2, "π/2"], [Math.PI, "π"], [3 * Math.PI / 2, "3π/2"], [2 * Math.PI, "2π"]]}, yaxis: {ticks: 10, min: -2, max: 2}, grid: {borderWidth: 0}, colors: ["#70AFC4", "#D9534F", "#A8BC7B", "#F0AD4E"]})
        }

        function i() {
            function t(t, e, i) {
                $('<div id="tooltip">' + i + "</div>").css({position: "absolute", display: "none", top: e + 5, left: t + 15, border: "1px solid #333", padding: "4px", color: "#fff", "border-radius": "3px", "background-color": "#333", opacity: .8}).appendTo("body").fadeIn(200)
            }

            var e = [
                [30, 10],
                [29, 24],
                [28, 38],
                [27, 32],
                [26, 31],
                [25, 25],
                [24, 35],
                [23, 46],
                [22, 36],
                [21, 48],
                [20, 38],
                [19, 60],
                [18, 63],
                [17, 72],
                [16, 58],
                [15, 65],
                [14, 50],
                [13, 32],
                [12, 40],
                [11, 35],
                [10, 30],
                [9, 35],
                [8, 50],
                [7, 53],
                [6, 42],
                [5, 34],
                [4, 22],
                [3, 15],
                [2, 20],
                [1, 5]
            ], i = [
                [1, 0],
                [2, 14],
                [3, 28],
                [4, 22],
                [5, 21],
                [6, 15],
                [7, 25],
                [8, 36],
                [9, 26],
                [10, 38],
                [11, 28],
                [12, 50],
                [13, 53],
                [14, 62],
                [15, 48],
                [16, 55],
                [17, 40],
                [18, 22],
                [19, 30],
                [20, 25],
                [21, 20],
                [22, 15],
                [23, 40],
                [24, 43],
                [25, 32],
                [26, 24],
                [27, 12],
                [28, 5],
                [29, 19],
                [30, 27]
            ];
            $.plot($("#chart_2"), [
                {data: e, label: "Unique Visits"},
                {data: i, label: "Page Views"}
            ], {series: {lines: {show: !0, lineWidth: 2, fill: !0, fillColor: {colors: [
                {opacity: .05},
                {opacity: .01}
            ]}}, points: {show: !0}, shadowSize: 2}, grid: {hoverable: !0, clickable: !0, tickColor: "#eee", borderWidth: 0}, colors: ["#DB5E8C", "#F0AD4E", "#5E87B0"], xaxis: {ticks: 11, tickDecimals: 0}, yaxis: {ticks: 11, tickDecimals: 0}});
            var n = null;
            $("#chart_2").bind("plothover", function (e, i, a) {
                if ($("#x").text(i.x.toFixed(2)), $("#y").text(i.y.toFixed(2)), a) {
                    if (n != a.dataIndex) {
                        n = a.dataIndex, $("#tooltip").remove();
                        var o = a.datapoint[0].toFixed(2), r = a.datapoint[1].toFixed(2);
                        t(a.pageX, a.pageY, a.series.label + " of " + o + " = " + r)
                    }
                } else $("#tooltip").remove(), n = null
            })
        }

        function n() {
            function t() {
                o = null;
                var t = r, e = plot.getAxes();
                if (!(t.x < e.xaxis.min || t.x > e.xaxis.max || t.y < e.yaxis.min || t.y > e.yaxis.max)) {
                    var i, n, s = plot.getData();
                    for (i = 0; i < s.length; ++i) {
                        var c = s[i];
                        for (n = 0; n < c.data.length && !(c.data[n][0] > t.x); ++n);
                        var l, d = c.data[n - 1], h = c.data[n];
                        l = null == d ? h[1] : null == h ? d[1] : d[1] + (h[1] - d[1]) * (t.x - d[0]) / (h[0] - d[0]), a.eq(i).text(c.label.replace(/=.*/, "= " + l.toFixed(2)))
                    }
                }
            }

            for (var e = [], i = [], n = 0; 14 > n; n += .1)e.push([n, Math.sin(n)]), i.push([n, Math.cos(n)]);
            plot = $.plot($("#chart_3"), [
                {data: e, label: "sin(x) = -0.00"},
                {data: i, label: "cos(x) = -0.00"}
            ], {series: {lines: {show: !0}}, crosshair: {mode: "x"}, grid: {hoverable: !0, borderWidth: 0, autoHighlight: !1}, yaxis: {min: -1.2, max: 1.2}, colors: ["#A8BC7B", "#FCD76A", "#F38630"]});
            var a = $("#chart_3 .legendLabel");
            a.each(function () {
                $(this).css("width", $(this).width())
            });
            var o = null, r = null;
            $("#chart_3").bind("plothover", function (e, i) {
                r = i, o || (o = setTimeout(t, 50))
            })
        }

        function a() {
            function e() {
                a.setData([t()]), a.draw(), setTimeout(e, n)
            }

            var i = {series: {shadowSize: 1}, lines: {show: !0, lineWidth: 1.5}, yaxis: {min: 0, max: 100, tickFormatter: function (t) {
                return t + "%"
            }}, xaxis: {show: !1}, colors: ["#D9534F"], grid: {tickColor: "#a8a3a3", borderWidth: 0}}, n = 30, a = $.plot($("#chart_4"), [t()], i);
            e()
        }

        function o() {
            function t() {
                $.plot($("#chart_5"), [e, n, a], {series: {stack: o, lines: {show: s, fill: !0, steps: c}, bars: {show: r, barWidth: .6}}, grid: {borderWidth: 0}, colors: ["#70AFC4", "#F0AD4E", "#A8BC7B"]})
            }

            for (var e = [], i = 0; 10 >= i; i += 1)e.push([i, parseInt(30 * Math.random())]);
            for (var n = [], i = 0; 10 >= i; i += 1)n.push([i, parseInt(30 * Math.random())]);
            for (var a = [], i = 0; 10 >= i; i += 1)a.push([i, parseInt(30 * Math.random())]);
            var o = 0, r = !0, s = !1, c = !1;
            $(".stackControls input").click(function (e) {
                e.preventDefault(), o = "With stacking" == $(this).val() ? !0 : null, t()
            }), $(".graphControls input").click(function (e) {
                e.preventDefault(), r = -1 != $(this).val().indexOf("Bars"), s = -1 != $(this).val().indexOf("Lines"), c = -1 != $(this).val().indexOf("steps"), t()
            }), t()
        }

        function r() {
            var t = [
                [5, 0],
                [10, 10],
                [20, 20],
                [30, 30],
                [40, 40],
                [50, 50],
                [60, 60]
            ], e = {series: {bars: {show: !0}}, bars: {horizontal: !0, barWidth: 6}, grid: {borderWidth: 0}, colors: ["#F38630"]};
            $.plot($("#chart_6"), [t], e)
        }

        function s() {
            function t(t, e) {
                for (var i = [], n = 0; 100 >= n; ++n) {
                    var a = t + n * (e - t) / 100;
                    i.push([a, Math.cos(a * Math.sin(a))])
                }
                return[
                    {label: "cos(x sin(x))", data: i}
                ]
            }

            var e = {grid: {hoverable: !0, clickable: !0, tickColor: "#f7f7f7", borderWidth: 0, labelMargin: 10, margin: {top: 0, left: 5, bottom: 0, right: 0}}, legend: {show: !1}, series: {lines: {show: !0}, shadowSize: 0, points: {show: !0}}, colors: ["#D9534F"], yaxis: {ticks: 10}, selection: {mode: "xy", color: "#F1ADAC"}}, i = t(0, 3 * Math.PI), n = $.plot("#placeholder", i, e), a = $.plot($("#overview"), i, {legend: {show: !1}, series: {lines: {show: !0, lineWidth: 1}, shadowSize: 0}, xaxis: {ticks: 4}, yaxis: {ticks: 3, min: -2, max: 2}, colors: ["#D9534F"], grid: {color: "#999", borderWidth: 0}, selection: {mode: "xy", color: "#F1ADAC"}});
            $("#placeholder").bind("plotselected", function (i, o) {
                o.xaxis.to - o.xaxis.from < 1e-5 && (o.xaxis.to = o.xaxis.from + 1e-5), o.yaxis.to - o.yaxis.from < 1e-5 && (o.yaxis.to = o.yaxis.from + 1e-5), n = $.plot("#placeholder", t(o.xaxis.from, o.xaxis.to), $.extend(!0, {}, e, {xaxis: {min: o.xaxis.from, max: o.xaxis.to}, yaxis: {min: o.yaxis.from, max: o.yaxis.to}})), a.setSelection(o, !0)
            }), $("#overview").bind("plotselected", function (t, e) {
                n.setSelection(e)
            }), $("#footer").prepend("Flot " + $.plot.version + " &ndash; ")
        }

        if (jQuery.plot) {
            var c = [], l = 300;
            e(), i(), s(), n(), a(), o(), r()
        }
    }, initPieCharts: function () {
        var t = [], e = Math.floor(9 * Math.random()) + 1;
        e = 6 > e ? 6 : e;
        for (var i = 0; e > i; i++)t[i] = {label: "Series" + (i + 1), data: Math.floor(100 * Math.random())};
        $.plot($("#donut"), t, {series: {pie: {innerRadius: .6, show: !0}}, colors: ["#D9534F", "#A8BC7B", "#F0AD4E", "#70AFC4", "#DB5E8C", "#FCD76A", "#A696CE"]});
    }, initOtherCharts: function () {
        function t() {
            function t(t, e, i) {
                $('<div id="tooltip">' + i + "</div>").css({position: "absolute", display: "none", top: e + 5, left: t + 15, border: "1px solid #333", padding: "4px", color: "#fff", "border-radius": "3px", "background-color": "#333", opacity: .8}).appendTo("body").fadeIn(200)
            }

            var e = [
                [0, 2.5],
                [1, 3.5],
                [2, 2],
                [3, 3],
                [4, 4],
                [5, 3.5],
                [6, 3.5],
                [7, 1],
                [8, 2],
                [9, 3],
                [10, 4],
                [11, 5],
                [12, 4],
                [13, 3],
                [14, 5],
                [15, 3.5],
                [16, 5],
                [17, 4],
                [18, 5],
                [19, 6],
                [20, 5],
                [21, 4],
                [22, 3],
                [23, 5],
                [24, 4],
                [25, 3],
                [26, 2],
                [27, 1],
                [28, 2],
                [29, 2],
                [30, 3],
                [31, 2]
            ];
            $.plot($("#chart_grow"), [
                {data: e, label: "Monthly Sales"}
            ], {series: {lines: {show: !0, lineWidth: 2, fill: !0, fillColor: {colors: [
                {opacity: .05},
                {opacity: .01}
            ]}}, points: {show: !0}, shadowSize: 2, grow: {active: !0, duration: 1500}}, grid: {hoverable: !0, clickable: !0, tickColor: "#eee", borderWidth: 0}, colors: ["#D9534F"], xaxis: {ticks: 11, tickDecimals: 0}, yaxis: {ticks: 11, tickDecimals: 0}});
            var i = null;
            $("#chart_2").bind("plothover", function (e, n, a) {
                if ($("#x").text(n.x.toFixed(2)), $("#y").text(n.y.toFixed(2)), a) {
                    if (i != a.dataIndex) {
                        i = a.dataIndex, $("#tooltip").remove();
                        var o = a.datapoint[0].toFixed(2), r = a.datapoint[1].toFixed(2);
                        t(a.pageX, a.pageY, a.series.label + " of " + o + " = " + r)
                    }
                } else $("#tooltip").remove(), i = null
            })
        }

        t()
    }}
}();