# [NAND2TETRIS](https://www.nand2tetris.org/)
---
#### This course teaches about building a computer using first principles.
Starting from project 01,need to build a set of elementary logic gates and complex logic gates, that is then abstracted and will serve as interfaces for the next project, that is again abstracted and will be used as interfaces for the next project, and so on, until the last project is reached.

---
### More specific details about each project
---

### Project 01

Built both elementary logic gates and complex logic gates, that can be used later on other projects.

---
### Project 02

Built half-adder, full-adder and ALU.

--- 
### Project 03

Built Bit, to 16-bit Register, to RAM up to 8K RAM. Also built a Program Counter.

---
### Project 04

Program the multiply logic, that stores the product of two numbers inside the Memory.
Also, programmed the screen and keyboard I/O logic. Whenever a button is pressed in the keyboard, the screen is black, and white when no button is pressed. All programs are coded using the Hack machine language.

---
### Project 05

Built the CPU and Memory. Then, with a built-in ROM32K, connected them together to build a working computer.

---
### Project 06

## Short description:
* A program that generates a machine code (.hack filetype) given an assembly file type(.asm)

### Install java and jdk
### Must have .asm file to test

### Instructions on how to use program:(Assembler.java) 
1. go to command line.
2. go to "nand2tetris/projects/06/assembler" directory.
2. Compile all the .java files using the command "javac Code.java Parser.java Symbol.java Assembler.java"
3. Run the Assembler.java file using the command "java Assembler <.asm filename>"
4. A .hack filetype with the same name as the .asm file will be generated to the same directory.

---
### Project 07
## Short description:
* A program that generates an assembly file type(.asm) given a virtual machine file type(.vm)
* Note: This is part 1 of the project VMTranslator. Project 7 & 8 focuses on building the VMTranslator.

## Install java and jdk
## Must have .vm file to test

### Instructions on how to use program:(VMTranslator.java) 
1. go to command line.
2. go to "nand2tetris/projects/07" directory.
2. Compile all the .java files using the command "javac CodeWriter.java Command.java CommandType.java Init.java Parser.java VMTranslator.java"
3. Run the VMTranslator.java file using the command "java VMTranslator <.asm filename>"
4. A .asm filetype with the same name as the .vm file will be generated to the same directory.