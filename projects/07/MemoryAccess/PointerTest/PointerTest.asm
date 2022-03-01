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
@3030

D=A
@0
A=M
M=D
@0
M=M+1
@3030
D=A
@3
M=D
@0
M=M-1
//push constant
@3040

D=A
@0
A=M
M=D
@0
M=M+1
@3040
D=A
@4
M=D
@0
M=M-1
//push constant
@32

D=A
@0
A=M
M=D
@0
M=M+1
@32
D=A
@3032
M=D
@0
M=M-1
//push constant
@46

D=A
@0
A=M
M=D
@0
M=M+1
@46
D=A
@3046
M=D
@0
M=M-1
//push constant
@3030

D=A
@0
A=M
M=D
@0
M=M+1
//push constant
@3040

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
@32
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
@46
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
