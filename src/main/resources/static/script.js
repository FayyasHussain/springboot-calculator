let currentInput = "";
let previousInput = "";
let operation = null;

function appendNum(num) {
  currentInput += num.toString();
  updateDisplay();
}

function appendDot() {
  if (!currentInput.includes(".")) {
    currentInput += ".";
    updateDisplay();
  }
}

function toggleSign() {
  if (currentInput) {
    currentInput = (parseFloat(currentInput) * -1).toString();
    updateDisplay();
  }
}

function handleOp(op) {
  if (op === "AC") {
    currentInput = "";
    previousInput = "";
    operation = null;
    updateDisplay();
    return;
  }

  if (op === "sqrt") {
    currentInput = Math.sqrt(parseFloat(currentInput)).toString();
    updateDisplay();
    return;
  }

  if (op === "%") {
    currentInput = (parseFloat(currentInput) / 100).toString();
    updateDisplay();
    return;
  }

  // Basic operators
  if (["+", "-", "*", "/"].includes(op)) {
    previousInput = currentInput;
    currentInput = "";
    operation = op;
    return;
  }


  previousInput = currentInput;
  operation = op;
  currentInput = "";
}

function calculate() {
  if (!operation || !previousInput || !currentInput) return;

  const a = parseFloat(previousInput);
  const b = parseFloat(currentInput);
  let result = 0;

  switch (operation) {
    case "+": result = a + b; break;
    case "-": result = a - b; break;
    case "*": result = a * b; break;
    case "/": result = b !== 0 ? a / b : "Err"; break;
  }

  currentInput = result.toString();
  operation = null;
  previousInput = "";
  updateDisplay();
}

function updateDisplay() {
  const display = document.getElementById("display");
  display.value = currentInput || "0";
}
