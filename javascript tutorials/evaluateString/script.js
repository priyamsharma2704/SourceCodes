evaluate("2+3-4*2");

function evaluate(str)
{
  console.log("test");
  var numStack = [];
  var opStack = [];

  var len = str.length;
  var i = 0;

  var num1 = str.charAt(i);
  i = i + 1;
  var op = str.charAt(i);
  i = i + 1;
  var num2 = str.charAt(i);
  //i = i + 1;
  numStack.push(num1);
  numStack.push(num2);
  opStack.push(op);

  while(i < len)
  {
    var num1 = str.charAt(i);
    i = i + 1;
    var op = str.charAt(i);
    i = i + 1;
    var num2 = str.charAt(i);

    var validFlag = isValidOp(op);
    if(!validFlag)
      return "not Valid Expression";

    var prec = findPrecedence(op, opStack);
    if(prec)
    {
      //solve stack first and then push elements  
      evaluateExp(numStack, opStack);
    }
    else
    {
      //since current op precedence is greater than topOp, so solve the current exp and push that result.
      evaluateCurrentExp(num1, num2, op);

    }
    numStack.push(num1);
    //numStack.push(parseInt(num2));
    opStack.push(op);
  }

  console.log(numStack);
  console.log(opStack);
}

function evaluateCurrentExp(num1, num2, op)
{
  var tempNumStack = [];
  tempNumStack.push(num1);
  tempNumStack.push(num2);

  var tempOpStack = [];
  tempOpStack.push(op);

  evaluateExp(tempNumStack, tempOpStack);
}

function evaluateExp(numStack, opStack)
{
  var num1 = numStack.pop();
  var num2 = numStack.pop();
  var op = opStack.pop();

  var res;
  switch(op)
  {
    case "-":
      res = parseFloat(num2) - parseFloat(num1);
      break;
    case "+":
      res = parseFloat(num2) + parseFloat(num1);
      break;
    case "*":
      res = parseFloat(num2) * parseFloat(num1);
      break;
    case "/":
      res = parseFloat(num2) / parseFloat(num1);
  }
  numStack.push(res);
}

function findPrecedence(op, opStack)
{
  var topOp = opStack[opStack.length -1];
  var topOpVal = getOpVal(topOp);
  var opVal = getOpVal(op);
  
  if(topOpVal > opVal)
    return true;    //solve the stack first
  else
  return false;
}

function getOpVal(op)
{
  switch(op)
  {
    case "-":
      return 0;
    case "+":
      return 1;
    case "*":
      return 2;
    case "/":
      return 3;
  }
}

function isValidOp(op)
{
  switch(op)
  {
    case "+":
    case "-":
    case "/":
    case "*":
      return true;
    default:
      return false;
  }
}