function Person (name)
{
    var m_name = name;

    this.getName = function()
    {
        return m_name;
    }
}

var p1 = new Person("Priyam");

console.log(p1.getName())