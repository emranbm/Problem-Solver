# Problem-Solver
A framework for solving some kinds of problems! Including:
* goal-based problems - Solved by **classical tree-search solvers**
  * DFS
  * Evolutionary DFS  
  * BFS  
  * Bidirectional BFS  
  * Backtracking  
* CSPs (or Constraint Satisfaction Problems) - Solved by **intelligent inexact solvers**
  * HillClimbing
    * Simple
    * First Choice
    * Random Choice
    * Random Restart
  * Genetic Algorithm

### Project structure
The project consists of 3 main parts:
* CSP
* goalBasedProblems
* utils

#### CSP
In CSP problems, the goal is not a predefined target; instead, the goal is to maximize (or minimize) something in the problem. These kinds of problems structure is implemented in the CSP package. Feel free to extend the abstract models and solve your problem!

#### goalBasedProblems
In this package, there is a variety of classical models to implement the problem based on them and let the framework to solve 'em!

#### utils
There is also a package named **utils**, including some shared classes and models between goal-based and CSP problems.

### Samples
There also some samples you can find in the corresponding packages to use and extend the abstarct models and solving them.
