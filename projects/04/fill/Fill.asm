// This file is part of www.nand2tetris.org
// and the book "The Elements of Computing Systems"
// by Nisan and Schocken, MIT Press.
// File name: projects/04/Fill.asm

// Runs an infinite loop that listens to the keyboard input.
// When a key is pressed (any key), the program blackens the screen,
// i.e. writes "black" in every pixel;
// the screen should remain fully black as long as the key is pressed. 
// When no key is pressed, the program clears the screen, i.e. writes
// "white" in every pixel;
// the screen should remain fully clear as long as no key is pressed.

// Put your code here.

@SET
(SET)
    @SCREEN
    D=A-1
    @addr
    M=D

    @8193
    D=A   
    @max
    M=D
    @i
    M=0

    @KEYBOARD      //GOTO KEYBOARD
    0;JMP

(KEYBOARD)
    @KBD
    D=M
    @value
    M=D

    @KBD
    D=M
    @LOOP_BLACK
        D;JEQ

    @KBD
    D=M
    @LOOP_BLACK
        D;JNE

// (SET_BLACK)
//     @value
//     M=0
//     @LOOP
//         0;JMP

// (SET_BLACK)
//     @value
//     M=-1
//     @LOOP
//         0;JMP

(LOOP_WHITE)
    @i
    D=M
    @max
    D=M-D
    @NO_CHANGE
        D;JEQ

    @addr
    A=M
    M=0
    @addr
    M=M+1

    @i
    M=M+1
    @LOOP
        0;JMP        

(LOOP_BLACK)
    @i
    D=M
    @max
    D=M-D
    @NO_CHANGE
        D;JEQ

    @addr
    A=M
    M=-1
    @addr
    M=M+1

    @i
    M=M+1
    @LOOP
        0;JMP


(NO_CHANGE)
    @KBD
    D=M
    @value
    D=M-D
    @SET
        D;JNE
    @NO_CHANGE
        D;JEQ