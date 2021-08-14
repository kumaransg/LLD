# Calculator
Designing a Calculator in Java using Command Pattern (Low Level Design)

5 Entities

1. Command Interface - to provide the structure a concrete command needs to implement.
2. Concrete Command Implementation - implements Command Interface and provides for execute and unexecute methods. Also provides undo alternative for each operator (+ > -, - > +, * > /, / > *).
3. Calculator - has a show value and also provides action for +,-,*,/.
4. Invoker - basically the user, computes and undos on request. Keeps a Stack of Commands in case needed to undo.
5. Calculator Test - driver of the code.
