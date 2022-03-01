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
@17

D=A
@0
A=M
M=D
@0
M=M+1
//push constant
@17

D=A
@0
A=M
M=D
@0
M=M+1
//eq command
@0
M=M-1
A=M
D=M
@0
M=M-1
A=M
M=-1
@0
M=M+1
//push constant
@17

D=A
@0
A=M
M=D
@0
M=M+1
//push constant
@16

D=A
@0
A=M
M=D
@0
M=M+1
//eq command
@0
M=M-1
A=M
D=M
@0
M=M-1
A=M
M=0
@0
M=M+1
//push constant
@16

D=A
@0
A=M
M=D
@0
M=M+1
//push constant
@17

D=A
@0
A=M
M=D
@0
M=M+1
//eq command
@0
M=M-1
A=M
D=M
@0
M=M-1
A=M
M=0
@0
M=M+1
//push constant
@892

D=A
@0
A=M
M=D
@0
M=M+1
//push constant
@891

D=A
@0
A=M
M=D
@0
M=M+1
//lt command
@0
M=M-1
A=M
D=M
@0
M=M-1
A=M
M=0
@0
M=M+1
//push constant
@891

D=A
@0
A=M
M=D
@0
M=M+1
//push constant
@892

D=A
@0
A=M
M=D
@0
M=M+1
//lt command
@0
M=M-1
A=M
D=M
@0
M=M-1
A=M
M=-1
@0
M=M+1
//push constant
@891

D=A
@0
A=M
M=D
@0
M=M+1
//push constant
@891

D=A
@0
A=M
M=D
@0
M=M+1
//lt command
@0
M=M-1
A=M
D=M
@0
M=M-1
A=M
M=0
@0
M=M+1
//push constant
@32767

D=A
@0
A=M
M=D
@0
M=M+1
//push constant
@32766

D=A
@0
A=M
M=D
@0
M=M+1
//gt command
@0
M=M-1
A=M
D=M
@0
M=M-1
A=M
M=-1
@0
M=M+1
//push constant
@32766

D=A
@0
A=M
M=D
@0
M=M+1
//push constant
@32767

D=A
@0
A=M
M=D
@0
M=M+1
//gt command
@0
M=M-1
A=M
D=M
@0
M=M-1
A=M
M=0
@0
M=M+1
//push constant
@32766

D=A
@0
A=M
M=D
@0
M=M+1
//push constant
@32766

D=A
@0
A=M
M=D
@0
M=M+1
//gt command
@0
M=M-1
A=M
D=M
@0
M=M-1
A=M
M=0
@0
M=M+1
//push constant
@57

D=A
@0
A=M
M=D
@0
M=M+1
//push constant
@31

D=A
@0
A=M
M=D
@0
M=M+1
//push constant
@53

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
//push constant
@112

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
//neg command
@0
M=M-1
A=M
M=-M
@0
M=M+1
//and command
@0
M=M-1
A=M
D=M
@0
M=M-1
A=M
M=D&M
@0
M=M+1
//push constant
@82

D=A
@0
A=M
M=D
@0
M=M+1
//or command
@0
M=M-1
A=M
D=M
@0
M=M-1
A=M
M=D|M
@0
M=M+1
//not command
@0
M=M-1
A=M
M=!M
@0
M=M+1
