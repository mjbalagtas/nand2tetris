//push constant
@111
D=A
@SP
A=M
M=D
@SP
M=M+1
//push constant
@333
D=A
@SP
A=M
M=D
@SP
M=M+1
//push constant
@888
D=A
@SP
A=M
M=D
@SP
M=M+1
@STATIC
A=M
D=M
@8
D=D+A
@13
M=D
@SP
AM=M-1
D=M
@13
A=M
M=D
@STATIC
A=M
D=M
@3
D=D+A
@13
M=D
@SP
AM=M-1
D=M
@13
A=M
M=D
@STATIC
A=M
D=M
@1
D=D+A
@13
M=D
@SP
AM=M-1
D=M
@13
A=M
M=D
@19
D=M
@SP
A=M
M=D
@SP
M=M+1
@17
D=M
@SP
A=M
M=D
@SP
M=M+1
//sub command
//sub command
@SP
M=M-1
A=M
D=M
@SP
M=M-1
A=M
D=D-M
D=-D
@SP
A=M
M=D
@SP
M=M+1
@24
D=M
@SP
A=M
M=D
@SP
M=M+1
//add command
@SP
M=M-1
A=M
D=M
@SP
M=M-1
A=M
D=D+M
@SP
A=M
M=D
@SP
M=M+1
(END)
@END
0;JMP
