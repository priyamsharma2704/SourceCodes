var point = function (x, y) 
{
    this.x = x;
    this.y = y;
};

// 0 2 1 1
// -2 -3 0 2
var p1 = new point(0, 2);
var p2 = new point(1, 1);
var p3 = new point(-2, -3);
var p4 = new point(0, 2);

validate(p1, p2, p3, p4);

function validate(p1, p2, p3, p4) 
{
    var newX1 = Math.max(p1.x, p3.x);
    var newX2 = Math.min(p2.x, p4.x);

    var newY1 = Math.max(p2.y, p4.y);
    var nmewY2 = Math.min(p1.y, p3.y);

    var w = newX2 - newX1;
    var h = nmewY2 - newY1;

    var area = w * h;
    if (area <= 0) console.log("do not overlap;");
    else console.log(area);
}
