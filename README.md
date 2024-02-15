IMPORTANT: accidentpack, main class and accidentpack README file are in the src folder. click the folder to access them
           I don't know what those other files are or what they do, they just appeared when I pushed the files I made

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
