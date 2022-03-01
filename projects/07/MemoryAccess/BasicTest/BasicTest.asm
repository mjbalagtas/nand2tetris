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
@10

D=A
@0
A=M
M=D
@0
M=M+1
@10
D=A
@300
M=D
@0
M=M-1
//push constant
@21

D=A
@0
A=M
M=D
@0
M=M+1
//push constant
@22

D=A
@0
A=M
M=D
@0
M=M+1
@22
D=A
@402
M=D
@0
M=M-1
@21
D=A
@401
M=D
@0
M=M-1
//push constant
@36

D=A
@0
A=M
M=D
@0
M=M+1
@36
D=A
@3006
M=D
@0
M=M-1
//push constant
@42

D=A
@0
A=M
M=D
@0
M=M+1
//push constant
@45

D=A
@0
A=M
M=D
@0
M=M+1
@45
D=A
@3015
M=D
@0
M=M-1
@42
D=A
@3012
M=D
@0
M=M-1
//push constant
@510

D=A
@0
A=M
M=D
@0
M=M+1
@510
D=A
@11
M=D
@0
M=M-1
@10
D=A
@0
A=M
M=D
@0
M=M+1
@45
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
@21
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
@36
D=A
@0
A=M
M=D
@0
M=M+1
@36
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
@510
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
