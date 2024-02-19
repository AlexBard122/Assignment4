IMPORTANT: accidentpack, main class and accidentpack README file are in the src folder. click the folder to access them
           I don't know what those other files are or what they do, they just appeared when I pushed the files I made
           
NOTE: README file for running the program4 program is in the accidentpack file, this README file discusses role assignment
           and GitHub repository details.

# Assignment4

Group Members: Alex Bard, Devin Chamberlain
Subtasks:
1:   main file to take in user input: state, county
     read accident reports into an arraylist (sorted based on date of start time (ascending))

2:   add all accidents that happened on the same day to a queue
      if a new day is found, create a new queue for that day
     find amount of time it takes to process a queue
      count total severity, *60 = process time
     1 counter = 1,440. figure out minimum number of counters it takes to process in 1 day
      process time / 1,440 = counters

3:   output should be: County: xx State: xx
                       xx seconds to simulate the process
                       minimum number of counters: xx
     command: java program4 accidents.csv

     Note: need to ask for clarification on what "xx seconds to simulate the process" means
           (is it program run time or something else?)

Roles:
Alex Bard: subtask 1 & 3 + initial GitHub setup + README file creation (may collaborate for final README file instructions for running the program)
Devin Chamberlain: subtask 2 + maybe helping with README file instructions (some parts of task 2 can be collaborated on if needed)

  Note: parts of final code which may be reassigned or collaborated on will be noted

  //Devin
  Order of complexity for task 2 items: 
  
  'getReportByCountyAndState' filter method = O(n) as it goes through all given items (n) once.
  
  'calculateCounters' method is O(n m^2) as it first calls 'getReportByCountyAndState' which is O(n) and then goes through the resultant list twice 
  (once to put in queue and a second time to process queue) which is O(m^2) resulting in a final order of complexity of O(n m^2).
