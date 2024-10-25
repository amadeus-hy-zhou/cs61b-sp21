# 0. dependency
1. Open JDK 17.0.1
2. IDEA 2023.1
3. maven 3.8

# 1. lab6
1. the usage of 'File' class
2. the usage of Makefile to manage projects

# 2. project2 Gitlet
## 2.1 Structure
```
.gitlet
    |--objects
    |    |--commit
    |    |--blob
    |--refs
    |    |--branches
    |--HEAD
    |--stage
    |    |--add
    |    |--remove
```
## 2.2 Classes and Data Strucutre
### 2.2.1 Commit
#### Instance Vairables
* Message - contains the message of a commit
* Parent - contains the information of the previous commit 
* timeStamp / Date - time at which a commit was created
