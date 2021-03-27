# The Quadric Surface Generator
Quadric surfaces are 3D extensions of conics in the Euclidean plane. There are 8 main types I've included in this 
program:
- Ellipsoid (or sphere if *a=b=c*)
- Elliptic paraboloid
- Hyperbolic paraboloid
- Elliptic cone
- Hyperboloid of one sheet
- Hyperboloid of two sheets
- Circular cylinder



***What will the application do?***

This application intends to be a study device for identifying quadric surfaces solely based on their equation.
Each of the quadric surfaces have distinct criteria for their equations, for example, an ellipsoid's equation must have
every variable *x,y,z* be positive. The user will input the number of questions they want generated, and the program 
will generate that number of quadric equations for the student to identify. They will be able to type in a box their 
answer, and if it's correct they can proceed to a new question. 


***Who will use it?***

There are a few groups that could benefit from this program:
- Math 200 students
- Professors who are annoyed with math 200 students constantly asking for more worksheets on identifying quadric 
surfaces, since 10 questions per unit is not nearly enough. In this case, they could just give the program to the 
students and have it generate infinite questions, thus never recieving a complaint about "not enough homework" ever 
again.
- Me

***Why is this project of interest?***

This idea came to mind when I was studying for my math exam which included the concept of identifying quadric surfaces. 
I looked for a simple program that would generate quadric surfaces for me to work on, since online worksheets proved to 
be unreliable and too short. To my surprise, no such program exists, so I thought it would be neat to make one!

## User Stories
- As a user, I want to be able to choose the number of questions that I will be tested on.
- As a user, I want to see the answer if I get a question wrong.
- As a user, I want to see my fraction based score for the quiz I just completed.
- As a user, I want to see my overall average for this quiz session until I exit the program.

**PHASE 2**


- I want to be able to save my quiz results to a json file.
- I want to be able to load all my past quiz results that I've previously saved.

**PHASE 3**
- As a user, I want to be able to add multiple (random) equations to the QuizPanel so I can be quized
on them all at once.
- As a user, I want to be able to click a button to load the previous state of the application and view
these loaded stats with a button.