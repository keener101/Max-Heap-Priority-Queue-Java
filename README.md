# Max-Heap-Priority-Queue-Java

BACKGROUND:

This Priority Queue project was made in a 300-level Data Structures course. I alone coded this project.


OVERVIEW:

 Priority Queue is a set of classes that work together to simulate a CPU processing 
 priority queue. Process objects are randomly generated and added to a PriorityQueue that
 utilizes a max heap data structure. The driver class simulates a CPU running a
 red robin algorithm for a set amount of time based on user input, and outputs the
 simulated results to the console.
 
 
INCLUDED FILES:

 CPUScheduling.java - source file (driver class, simulates the CPU()
 Averager.java - source file (keeps track of simulated data and calcuates averages)
 Process.java - source file (represents a single Process for a CPU to run
 MaxHeap.java - source file (represents a max heap data structure)
 ProcessGenerator.java - source file (creates random processes)
 PQueue.java - source file (represents a priority queue with MaxHeap of Process objects)
 README - this document


BUILDING AND RUNNING:

 Navigate to the directory containing all the source files. To check
 that you are in the correct directory, you can check the contents with
 the command:
 
 $ ls

 Compile all the .java files with the command:
 
 $ javac *.java

 Afterwards, you can test the compiled CPUScheduling class with the 
 command format:
 
$ java CPUScheduling 1 2 3 4 1.0
 
 Where 1, 2, 3, 4, and 1.0 represent specific console argument to modify the program.
 All of the arguments are integers, except 1.0 which should be a double between 0.0 and
 1.0.
 
 Argument 1 represents the maximum process time a Process can have for this simulation.
 
 Argument 2 represents the maximum priority level a Process can have
 
 Argument 3 represents how many unit time increments must pass until the priority of a 
 untouched Process is increased by one.
 
 Argument 4 represents how many unit time cycles the simulation will run for
 
 Argument 5 represents the probability a new Process will be created each unit time.
 This should be a double that ranges between 0.0 (never happens) and 1.0 (always happens).
  
 If the arguments are entered incorrectly, an error message will print to the console
 with these directions.

PROGRAM DESIGN:

 CPUScheduling uses a red-robin algorithm to simulate given Processes over a set amount
 of unit time. To accomplish this, it uses several classes. The most basic of these is 
 Process, which merely represents a single computer task that needs to be computed. 
 Process only contains a few variables containing its priority level, the time it was
 created, and the time it takes for the CPU to compute that process. Process also 
 overrides compareTo(), and allows for a Process to be compared to another Process via
 priority values. 
  
 The underlying data structure used to implement red-robin scheduling is a priority 
 queue utilizing a max heap. These represent two different classes in this program, 
 where PQueue (the priority queue) is a wrapper of MaxHeap using Process objects. 
 
 MaxHeap uses an array-based implementation (via ArrayList) to navigate and sort the 
 heap. Heap sorting is done recursively, by checking the children of a specified node, 
 and then checking the children of the children, and so on. Specifying the first node
 as the start of this process results in all nodes being checked and sorted.
 
 PQueue creates a MaxHeap using Process objects, and handles Process objects as they are
 added and removed from the heap. To do this, it will add a Process to the end of the 
 queue, and rebuild the heap, or it will remove the first process (the root node of
 the heap) and then rebuild the heap.
 
 ProcessGenerator creates random Processes that are added to the PQueue based on a 
 given probability between 0.0 and 1.0, where 0.0 means a Process is never added and 
 1.0 means a Process is created every unit time. User inputs can specify the range of 
 two randomly assigned values - the priority of the process and how long it takes the 
 process to be computer.
 
 CPUScheduling uses this PQueue and ProcessGenerator in tandem. When a process is 
 added, it goes into the PQueue and the heap is sorted. The top Process is removed from
 the PQueue and is calculated during the unit time cycles. While this is being calculated
 the PQueue will continue to randomly add Process objects and the heap will be rebuilt
 with each addition. When the Process is done being computed, the top Process is removed
 from the current heap and the cycle starts again. If a task has existed in the PQueue for
 some time without being ran, it will have its priority level increased by one. This 
 prevents some lower-priority Process objects from being "starved" (i.e., never ran 
 due to always having higher level Process objects chosen over it).
 
    
TESTING:

 Testing was done by running the following command line arguments, and comparing it to 
 a given example output. This was done several times, and some variance was noted. In 
 the sole example provided, the average Process turnaround time was ~16.5 units. Values
 around this mark were frequently seen, however I also observed values as low as ~6 units
 and as high as ~22 units. 
 
 To further verify, I ran the debugger and followed an entire simulation through step
 by step and confirmed the logic ran correctly. 
 

DISCUSSION:
 
 This was a difficult project for me that I struggled with. For me, the open-ended 
 instructions made this project seem overwhelming at times. On one hand, this made me
 understand how the parts had to work together before I built them. On the other hand, 
 I often found myself wondering if I had missed a method in several classes or had added
 unneeded ones. I think in the future, it would improve the quality of this project if
 some essential methods were given more information - for instance, I did not understand
 what the query() method in ProcessGenerator was supposed to do at first, and had to 
 spend quite some time piecing it together. Additionally, it was not very clear to me 
 how responsibilities were split between MaxHeap and PQueue - I ended up making PQueue 
 simply a wrapper class - but was it really needed? I'm still not sure.
 
 I will say that I felt absolutely great after I finished this project. I had struggled
 with recursion during 221 (it was my only missed question on the final), so I was 
 very worried about implementing the maxHeapify() method recursively. However, I planned
 it out and it just made so much logical sense once I coded it. Simply by making me
 feel more comfortable with recursion, this project was worth it.  
 
 One final thing that I think could be improved - it is very difficult to tell whether
 or not your output is correct simply by comparing it with the provided example output.
 There are two ways I think this could be improved. First, you could design the driver
 class to print to console when a process's priority is increased, and what process is 
 currently "loaded" into the CPU. This could make tracking the output much easier, as
 you wouldn't have to count lines to manually keep track of priority. The second 
 possible fix would be to have this program run 1,000 times (or some similarly large 
 value), and compare the averages across all those simulations. This would minimize the
 variance seen from the example parameters (6-22 units, where the example gives 16.5).