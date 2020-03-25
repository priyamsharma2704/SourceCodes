function test()
{
    return new Promise((resolve, reject) =>
    {
        let flag = false;

        if (flag)
            resolve("Passed");
        else
            reject("Failed");
    });
}


test().then((msg) =>
{
    console.log(msg)
}).catch((msg) =>
{ 
    console.log(msg);
})