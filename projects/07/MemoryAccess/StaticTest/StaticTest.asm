//INITIALIZE
@256
D=A
@0
M=D
@300

D=A
@1
M=D
@400

D=A
@2
M=D
@3000

D=A
@3
M=D
@3010

D=A
@4
M=D
D=0
// END OF INITIALIZER

//push constant
@111

D=A
@0
A=M
M=D
@0
M=M+1
//push constant
@333

D=A
@0
A=M
M=D
@0
M=M+1
//push constant
@888

D=A
@0
A=M
M=D
@0
M=M+1
@888
D=A
@24
M=D
@0
M=M-1
@333
D=A
@19
M=D
@0
M=M-1
@111
D=A
@17
M=D
@0
M=M-1
@333
D=A
@0
A=M
M=D
@0
M=M+1
@111
D=A
@0
A=M
M=D
@0
M=M+1
//sub command
//sub command
@0
M=M-1
A=M
D=M
@0
M=M-1
A=M
D=D-M
D=-D
@0
A=M
M=D
@0
M=M+1
@888
D=A
@0
A=M
M=D
@0
M=M+1
//add command
@0
M=M-1
A=M
D=M
@0
M=M-1
A=M
D=D+M
@0
A=M
M=D
@0
M=M+1
