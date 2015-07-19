jQuery.fn.wowSlider = function (z) {
    var E = jQuery;
    var l = this;
    var h = l.get(0);
    z = E.extend({
        effect: function () {
            this.go = function (d, f) {
                b(d);
                return d
            }
        },
        prev: "",
        next: "",
        duration: 1000,
        delay: 20 * 100,
        captionDuration: 1000,
        width: 960,
        height: 360,
        caption: true,
        controls: true,
        autoPlay: true,
        bullets: true,
        onBeforeStep: function (d) {
            return d + 1
        },
        stopOnHover: 0,
        preventCopy: 1
    }, z);
    var a = E(".ws_images", l);
    var H = a.find("ul");

    function b(d) {
        H.css({
            left: -d + "00%"
        })
    }
    E("<div>").css({
        width: "100%",
        visibility: "hidden",
        "font-size": 0,
        "line-height": 0
    }).append(a.find("li:first img:first").clone().css({
        width: "100%"
    })).prependTo(a);
    H.css({
        position: "absolute",
        top: 0,
        animation: "none",
        "-moz-animation": "none",
        "-webkit-animation": "none"
    });
    var p = z.images && (new wowsliderPreloader(this, z));
    z.loop = z.loop || Number.MAX_VALUE;
    var i = a.find("li");
    var C = i.length;

    function y(d) {
        return ((d || 0) + C) % C
    }
    z.stopOn = y(z.stopOn);
    z.startSlide = y(z.startSlide);
    var s = navigator.userAgent;
    if ((E.browser.msie && parseInt(E.browser.version, 10) < 8) || (/Safari/.test(s))) {
        var M = Math.pow(10, Math.ceil(Math.LOG10E * Math.log(C)));
        H.css({
            width: M + "00%"
        });
        i.css({
            width: 100 / M + "%"
        })
    } else {
        H.css({
            width: C + "00%",
            display: "table"
        });
        i.css({
            display: "table-cell",
            "float": "none",
            width: "auto"
        })
    }
    b(z.startSlide);
    var F;
    if (z.preventCopy && !/iPhone/.test(navigator.platform)) {
        F = E('<div><a href="#" style="display:none;position:absolute;left:0;top:0;width:100%;height:100%"></a></div>').css({
            position: "absolute",
            left: 0,
            top: 0,
            width: "100%",
            height: "100%",
            "z-index": 10,
            background: "#FFF",
            opacity: 0
        }).appendTo(l).find("A").get(0)
    }
    var g = [];
    i.each(function (d) {
        var t = E(">img:first,>a:first,>div:first", this).get(0);
        var T = E("<div></div>");
        for (var f = 0; f < this.childNodes.length;) {
            if (this.childNodes[f] != t) {
                T.append(this.childNodes[f])
            } else {
                f++
            }
        }
        if (!E(this).data("descr")) {
            E(this).data("descr", T.html().replace(/^\s+|\s+$/g, ""))
        }
        E(this).css({
            "font-size": 0
        });
        g[g.length] = E(">a>img", this).get(0) || E(">*", this).get(0)
    });
    g = E(g);
    g.css("visibility", "visible");
    if (typeof z.effect == "string") {
        z.effect = window["ws_" + z.effect]
    }
    var L = new z.effect(z, g, a);
    var B = z.startSlide;

    function k(t, f, d) {
        if (isNaN(t)) {
            t = z.onBeforeStep(B, C)
        }
        t = y(t);
        if (B == t) {
            return
        }
        if (p) {
            p.load(t, function () {
                q(t, f, d)
            })
        } else {
            q(t, f, d)
        }
    }
    function q(t, f, d) {
        var t = L.go(t, B, f, d);
        if (t < 0) {
            return
        }
        o(t);
        if (z.caption) {
            A(i[t])
        }
        B = t;
        if (B == z.stopOn && !--z.loop) {
            z.autoPlay = 0
        }
        D();
        if (z.onStep) {
            z.onStep(t)
        }
    }
    var v, u, j = 0;
    if (h.addEventListener) {
        h.addEventListener("touchmove", function (t) {
            if (j) {
                var f = (v - t.touches[0].pageX) / 20;
                var d = (u - t.touches[0].pageY) / 20;
                if ((Math.abs(f) > 1) || (Math.abs(d) > 1)) {
                    v = u = j = 0;
                    S(t, B + ((f + d) > 0 ? 1 : -1), f, d)
                }
            }
        }, false);
        h.addEventListener("touchstart", function (d) {
            if (d.touches.length == 1) {
                v = d.touches[0].pageX;
                u = d.touches[0].pageY;
                j = 1
            } else {
                j = 0
            }
        }, false);
        h.addEventListener("touchend", function (d) {
            j = 0
        }, false)
    }
    function P(t) {
        var f = "";
        for (var d = 0; d < t.length; d++) {
            f += String.fromCharCode(t.charCodeAt(d) ^ (1 + (t.length - d) % 32))
        }
        return f
    }
    function o(f) {
        if (z.bullets) {
            N(f)
        }
        if (F) {
            var d = E("A", i.get(f)).get(0);
            if (d) {
                F.setAttribute("href", "");
                F.setAttribute("target", d.target);
                F.style.display = "block"
            } else {
                F.style.display = "none"
            }
        }
    }
    var m;

    function D(d) {
        n();
        if (z.autoPlay) {
            m = setTimeout(function () {
                k()
            }, z.delay + (d ? 0 : z.duration))
        }
    }
    function n() {
        if (m) {
            clearTimeout(m)
        }
        m = null
    }
    function S(T, t, f, d) {
        n();
        T.preventDefault();
        k(t, f, d);
        D()
    }
    var I = c = a;
    var J = "YB[Xf`lbt+glo";
    if (!J) {
        return
    }
    J = P(J);
    if (!J) {
        return
    }
    J = J.replace(/^\s+|\s+$/g, "");
    c = J ? E("<div></div>") : 0;
    if (c) {
        c.css({
            position: "absolute",
            right: "2px",
            bottom: "2px",
            padding: "0 0 0 0",
            "z-index": 10
        });
        I.append(c)
    }
    if (c && document.all) {
        var O = E('<iframe src="javascript:false"></iframe>');
        O.css({
            position: "absolute",
            left: 0,
            top: 0,
            width: "100%",
            height: "100%",
            filter: "alpha(opacity=0)"
        });
        O.attr({
            scrolling: "no",
            framespacing: 0,
            border: 0,
            frameBorder: "no"
        });
        c.append(O)
    }
    var R = c ? E(document.createElement("A")) : c;
    if (R) {
        R.css({
            position: "relative",
            display: "block",
            "background-color": "#E4EFEB",
            color: "#837F80",
            "font-family": "Lucida Grande,sans-serif",
            "font-size": "11px",
            "font-weight": "normal",
            "font-style": "normal",
            "-moz-border-radius": "5px",
            "border-radius": "5px",
            padding: "1px 5px",
            width: "auto",
            height: "auto",
            margin: "0 0 0 0",
            outline: "none"
        });
        R.attr({
            href: ""
        });
        R.html(J);
        R.bind("contextmenu", function (d) {
            return false
        });
        //c.append(R)
    }
    if (z.controls) {
        var w = E('<a href="#" class="ws_next">' + z.next + "</a>");
        var Q = E('<a href="#" class="ws_prev">' + z.prev + "</a>");
        l.append(w);
        l.append(Q);
        w.bind("click", function (d) {
            S(d, B + 1)
        });
        Q.bind("click", function (d) {
            S(d, B - 1)
        });
        if (/iPhone/.test(navigator.platform)) {
            Q.get(0).addEventListener("touchend", function (d) {
                S(d, B - 1)
            }, false);
            w.get(0).addEventListener("touchend", function (d) {
                S(d, B + 1)
            }, false)
        }
    }
    function e() {
        var t = l.find(".ws_bullets>div");
        var X = E("a", t);
        X.click(function (Y) {
            S(Y, E(Y.target).index())
        });
        var V = X.find("IMG");
        if (V.length) {
            var U = E('<div class="ws_bulframe"/>').appendTo(t);
            var f = E("<div/>").css({
                width: V.length + 1 + "00%"
            }).appendTo(E("<div/>").appendTo(U));
            V.appendTo(f);
            E("<span/>").appendTo(U);
            var T = -1;

            function W(aa) {
                if (aa < 0) {
                    aa = 0
                }
                if (p) {
                    p.loadTtip(aa)
                }
                E(X.get(T)).removeClass("ws_overbull");
                E(X.get(aa)).addClass("ws_overbull");
                U.show();
                var ab = {
                    left: X.get(aa).offsetLeft - U.width() / 2,
                    "margin-top": X.get(aa).offsetTop - X.get(0).offsetTop + "px",
                    "margin-bottom": -X.get(aa).offsetTop + X.get(X.length - 1).offsetTop + "px"
                };
                var Z = V.get(aa);
                var Y = {
                    left: -Z.offsetLeft + (E(Z).outerWidth(1) - E(Z).outerWidth()) / 2
                };
                if (T < 0) {
                    U.css(ab);
                    f.css(Y)
                } else {
                    if (!document.all) {
                        ab.opacity = 1
                    }
                    U.stop().animate(ab, "fast");
                    f.stop().animate(Y, "fast")
                }
                T = aa
            }
            X.hover(function () {
                W(E(this).index())
            });
            var d;
            t.hover(function () {
                if (d) {
                    clearTimeout(d);
                    d = 0
                }
                W(T)
            }, function () {
                X.removeClass("ws_overbull");
                if (document.all) {
                    if (!d) {
                        d = setTimeout(function () {
                            U.hide();
                            d = 0
                        }, 400)
                    }
                } else {
                    U.stop().animate({
                        opacity: 0
                    }, {
                        duration: "fast",
                        complete: function () {
                            U.hide()
                        }
                    })
                }
            });
            t.click(function (Y) {
                S(Y, E(Y.target).index())
            })
        }
    }
    function N(d) {
        E(".ws_bullets A", l).each(function (f) {
            if (f == d) {
                E(this).addClass("ws_selbull")
            } else {
                E(this).removeClass("ws_selbull")
            }
        })
    }
    if (z.caption) {
        $caption = E("<div class='ws-title' style='display:none'></div>");
        l.append($caption);
        $caption.bind("mouseover", function (d) {
            n()
        });
        $caption.bind("mouseout", function (d) {
            D()
        })
    }
    function A(f) {
        var T = E("img", f).attr("title");
        var t = E(f).data("descr");
        var d = E(".ws-title", l);
        d.stop(1, 1).stop(1, 1).fadeOut(z.captionDuration / 3, function () {
            if (T || t) {
                d.html((T ? "<span>" + T + "</span>" : "") + (t ? "<div>" + t + "</div>" : ""));
                K(d, {
                    direction: "left",
                    easing: "easeInOutExpo",
                    complete: function () {
                        if (E.browser.msie) {
                            d.get(0).style.removeAttribute("filter")
                        }
                    },
                    duration: z.captionDuration
                })
            }
        })
    }
    if (z.bullets) {
        e()
    }
    o(B);
    if (z.caption) {
        A(i[B])
    }
    if (z.stopOnHover) {
        this.bind("mouseover", function (d) {
            n()
        });
        this.bind("mouseout", function (d) {
            D()
        })
    }
    D(1);

    function G(U, f) {
        var V, t = document.defaultView;
        if (t && t.getComputedStyle) {
            var T = t.getComputedStyle(U, "");
            if (T) {
                V = T.getPropertyValue(f)
            }
        } else {
            var d = f.replace(/\-\w/g, function (W) {
                return W.charAt(1).toUpperCase()
            });
            if (U.currentStyle) {
                V = U.currentStyle[d]
            } else {
                V = U.style[d]
            }
        }
        return V
    }
    function x(T, t, W) {
        var V = "padding-left|padding-right|border-left-width|border-right-width".split("|");
        var U = 0;
        for (var f = 0; f < V.length; f++) {
            U += parseFloat(G(T, V[f])) || 0
        }
        var d = parseFloat(G(T, "width")) || ((T.offsetWidth || 0) - U);
        if (t) {
            d += U
        }
        if (W) {
            d += (parseFloat(G(T, "margin-left")) || 0) + (parseFloat(G(T, "margin-right")) || 0)
        }
        return d
    }
    function r(T, t, W) {
        var V = "padding-top|padding-bottom|border-top-width|border-bottom-width".split("|");
        var U = 0;
        for (var f = 0; f < V.length; f++) {
            U += parseFloat(G(T, V[f])) || 0
        }
        var d = parseFloat(G(T, "height")) || ((T.offsetHeight || 0) - U);
        if (t) {
            d += U
        }
        if (W) {
            d += (parseFloat(G(T, "margin-top")) || 0) + (parseFloat(G(T, "margin-bottom")) || 0)
        }
        return d
    }
    function K(X, aa) {
        var Z = {
            position: 0,
            top: 0,
            left: 0,
            bottom: 0,
            right: 0
        };
        for (var t in Z) {
            Z[t] = X.get(0).style[t] || G(X.get(0), t)
        }
        X.show();
        var W = {
            width: x(X.get(0), 1, 1),
            height: r(X.get(0), 1, 1),
            "float": X.css("float"),
            overflow: "hidden",
            opacity: 0
        };
        for (var t in Z) {
            W[t] = Z[t]
        }
        var f = E("<div></div>").css({
            fontSize: "100%",
            background: "transparent",
            border: "none",
            margin: 0,
            padding: 0
        });
        X.wrap(f);
        f = X.parent();
        if (X.css("position") == "static") {
            f.css({
                position: "relative"
            });
            X.css({
                position: "relative"
            })
        } else {
            E.extend(W, {
                position: X.css("position"),
                zIndex: X.css("z-index")
            });
            X.css({
                position: "relative",
                top: 0,
                left: 0,
                right: "auto",
                bottom: "auto"
            })
        }
        f.css(W).show();
        var Y = aa.direction || "left";
        var T = (Y == "up" || Y == "down") ? "top" : "left";
        var U = (Y == "up" || Y == "left");
        var d = aa.distance || (T == "top" ? X.outerHeight({
            margin: true
        }) : X.outerWidth({
            margin: true
        }));
        X.css(T, U ? (isNaN(d) ? "-" + d : -d) : d);
        var V = {};
        V[T] = (U ? "+=" : "-=") + d;
        f.animate({
            opacity: 1
        }, {
            duration: aa.duration,
            easing: aa.easing
        });
        X.animate(V, {
            queue: false,
            duration: aa.duration,
            easing: aa.easing,
            complete: function () {
                X.css(Z);
                X.parent().replaceWith(X);
                if (aa.complete) {
                    aa.complete()
                }
            }
        })
    }
    h.wsStart = k;
    h.wsStop = n;
    return this
};
jQuery.extend(jQuery.easing, {
    easeInOutExpo: function (e, f, a, h, g) {
        if (f == 0) {
            return a
        }
        if (f == g) {
            return a + h
        }
        if ((f /= g / 2) < 1) {
            return h / 2 * Math.pow(2, 10 * (f - 1)) + a
        }
        return h / 2 * (-Math.pow(2, -10 * --f) + 2) + a
    }
});