@ARG
D=M
@1
AD=D+A
A=D
D=M
@SP
A=M
M=D
@SP
M=M+1
@SP
AM=M-1
D=M
@THAT
M=D
//push constant
@0
D=A
@SP
A=M
M=D
@SP
M=M+1
@THAT
D=M
@0
AD=D+A
@13
M=D
@SP
AM=M-1
D=M
@13
A=M
M=D
//push constant
@1
D=A
@SP
A=M
M=D
@SP
M=M+1
@THAT
D=M
@1
AD=D+A
@13
M=D
@SP
AM=M-1
D=M
@13
A=M
M=D
@ARG
D=M
@0
AD=D+A
A=D
D=M
@SP
A=M
M=D
@SP
M=M+1
//push constant
@2
D=A
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
@ARG
D=M
@0
AD=D+A
@13
M=D
@SP
AM=M-1
D=M
@13
A=M
M=D
(MAIN_LOOP_START)
@ARG
D=M
@0
AD=D+A
A=D
D=M
@SP
A=M
M=D
@SP
M=M+1
@ARG
D=M
@0
AD=D+A
@13
M=D
@SP
AM=M-1
D=M
@13
A=M
M=D
@COMPUTE_ELEMENT
D;JNE
@END_PROGRAM
0;JMP
(COMPUTE_ELEMENT)
@THAT
D=M
@0
AD=D+A
A=D
D=M
@SP
A=M
M=D
@SP
M=M+1
@THAT
D=M
@1
AD=D+A
A=D
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
@THAT
D=M
@2
AD=D+A
@13
M=D
@SP
AM=M-1
D=M
@13
A=M
M=D
@THAT
D=M
@SP
A=M
M=D
@SP
M=M+1
//push constant
@1
D=A
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
@SP
AM=M-1
D=M
@THAT
M=D
@ARG
D=M
@0
AD=D+A
A=D
D=M
@SP
A=M
M=D
@SP
M=M+1
//push constant
@1
D=A
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
@ARG
D=M
@0
AD=D+A
@13
M=D
@SP
AM=M-1
D=M
@13
A=M
M=D
@MAIN_LOOP_START
0;JMP
(END_PROGRAM)
(END)
@END
0;JMP
