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
@0

D=A
@0
A=M
M=D
@0
M=M+1
//push constant ends here
//pop command
@0
D=A
@300
M=D
@0
M=M-1
//pop command ends here
//writeLabel command starts here
(LOOP_START)
//writeLabel command ends here
//push command
@3
D=A
@256
M=D
@0
M=M+1
//push command ends here
//push command
@0
D=A
@257
M=D
@0
M=M+1
//push command ends here
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
//pop command
@3
D=A
@300
M=D
@0
M=M-1
//pop command ends here
//push command
@3
D=A
@256
M=D
@0
M=M+1
//push command ends here
//push constant
@1

D=A
@0
A=M
M=D
@0
M=M+1
//push constant ends here
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
//sub command ends here
//pop command
@2
D=A
@400
M=D
@0
M=M-1
//pop command ends here
//push command
@2
D=A
@256
M=D
@0
M=M+1
//push command ends here
//writeIf command starts here
@400
D=M
@LOOP_START
D;JNE
//push command
@3
D=A
@257
M=D
@0
M=M+1
//push command ends here
