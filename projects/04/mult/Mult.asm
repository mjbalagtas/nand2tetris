// This file is part of www.nand2tetris.org
// and the book "The Elements of Computing Systems"
// by Nisan and Schocken, MIT Press.
// File name: projects/04/Mult.asm

// Multiplies R0 and R1 and stores the result in R2.
// (R0, R1, R2 refer to RAM[0], RAM[1], and RAM[2], respectively.)
//
// This program only needs to handle arguments that satisfy
// R0 >= 0, R1 >= 0, and R0*R1 < 32768.

// Put your code here.

@R2
M=0

@R0
D=M
@END
    D;JEQ

@R1
D=M
@END
    D;JEQ

@R1
D=M
@i
M=D

@LOOP

(LOOP)
    @i
    D=M
    @END
        D;JEQ
    @R0
        D=M
    @R2
        M=M+D
    @i
        M=M-1
    @LOOP
        0;JMP

(END)
    @END
        0;JMP


//SET R1
// @R1
//     D=M
// @i
//     M=D
// @is_negative
//     M=0
// @sum
//     M=0


// (END_ZERO)
//     @R2
//         M=0
//     @END
//         0;JMP

// @R2
//     D=M
//     @END_ZERO
//         D;JEQ


// @NEGATIVE_ITERATOR
//     @i
//         D=M
//     @LOOP
//         D;JGT

// (NEGATIVE_ITERATOR)
//     @is_negative
//         M=-1
//     @i
//         M=-M
//     @LOOP
//         0;JMP


// (LOOP)
//     @i
//         D=M
//     @STOP
//         D;JEQ
//     @R0
//         D=M
//     @sum
//         M=M+D
//     @i
//         D=M
//     @i
//         M=D-1
//     @LOOP
//         0;JEQ

// (STOP)
//     @is_negative
//         D=M
//     @INVERT
//         D;JLT
//     @sum
//         D=M
//     @R2
//         M=D
//     @END
//         0;JMP

// (INVERT)
//     @sum
//         D=-M
//     @R2
//         M=D
//     @END
//         0;JMP

// (END)
//     @END
//         0;JMP