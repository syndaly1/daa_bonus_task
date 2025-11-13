# Bonus Task – Edge Removal from an MST
**Student:** Syndaly Yerzhan, SE-2424

In this project, I constructed a Minimum Spanning Tree (MST), removed one MST edge, analyzed how the tree splits into two components, and identified the smallest-weight edge that reconnects these components to restore a valid MST.

---

## 1. Program Functionality

The program performs all required steps of the task:

###  Build the Minimum Spanning Tree (MST)
Using **Kruskal’s algorithm** with **Disjoint Set Union (DSU)**.

###  Display the MST before removing any edge
All MST edges and the total MST weight are printed.

###  Remove one edge from the MST
The selected MST edge is removed.

###  Show resulting components
The tree becomes disconnected.  
Both components are found using DFS.

###  Find a replacement edge
The algorithm checks all edges of the original graph that connect the two components and selects the **lightest** one.

###  Display the updated MST
The replacement edge is added, forming a valid MST again.

---

## 2. Project Structure
src/ main/ java/ algo/

└── Edge.java

└── Graph.java

└── DSU.java

└── KruskalMST.java

└── ConnectedComponents.java

└── ReplacementEdgeFinder.java

└── Main.java

### Class Responsibilities

- **Graph** – stores vertices and weighted edges
- **Edge** – represents a weighted undirected edge
- **DSU** – union–find structure used in Kruskal’s algorithm
- **KruskalMST** – constructs the MST
- **ConnectedComponents** – finds components after an MST edge is removed
- **ReplacementEdgeFinder** – selects the minimum-weight edge reconnecting components
- **Main** – executes all required steps and prints results

---

## 3. Output (based on program run)

**Initial MST (before removal):**
- 0 - 3 (w=5)
- 2 - 4 (w=5)
- 3 - 5 (w=6)
- 0 - 1 (w=7)
- 1 - 4 (w=7)
- 4 - 6 (w=9)  
  **Total weight:** 39

**Removed edge:** 3 - 5 (w=6)

**Components after removal:**
- Component A: [0, 1, 2, 3, 4, 6]
- Component B: [5]

**Candidate edges that reconnect components:**
- 3 - 5 (w=6)
- 4 - 5 (w=8)
- 5 - 6 (w=11)

**Replacement edge:**
- 3 - 5 (w=6)

**New MST (after reconnection):**
- 0 - 3 (w=5)
- 2 - 4 (w=5)
- 0 - 1 (w=7)
- 1 - 4 (w=7)
- 4 - 6 (w=9)
- 3 - 5 (w=6)  
  **Total weight:** 39

---
## 4. How to Run the Program

1. Clone the repository **or** download the project as a ZIP archive.
2. If you downloaded the ZIP, extract (unzip) the folder.
3. Open the project in **IntelliJ IDEA**.
4. Navigate to:
   src/main/java/algo/Main.java
5. Run the file using **“Run Main”**.

---
## 5. Conclusion
As a result of completing this bonus task, I successfully implemented all the required steps.
I correctly constructed the Minimum Spanning Tree (MST), then removed one of its edges and identified how the tree splits into two separate components. After that, I examined all possible edges that could reconnect these components and selected the one with the smallest weight.
By adding this edge back to the structure, I restored a valid MST, and the total weight of the tree remained the same as in the original version.






