# DSU Modeling Intuition: Choose the Right Level of Nodes

The biggest optimization in many DSU problems comes from **changing what a node represents**.

Instead of treating every smallest object as a node and connecting them one by one, represent the **higher-level entity responsible for their connectivity** as the node.

This avoids explicitly connecting every individual object. The input already tells us which higher-level entities are connected, so we only need to union those. Once those higher-level entities are connected, every smaller object belonging to them automatically becomes part of the same connected component.

---

## Accounts Merge

Input

```text
Account1
├── a@gmail.com
└── b@gmail.com

Account2
├── b@gmail.com
└── c@gmail.com
```

The connectivity is created by **emails**.

Instead of directly connecting accounts,

```text
Account1 -------- Account2
```

represent the graph using emails.

```text
a@gmail
    |
b@gmail
    |
c@gmail
```

The common email naturally joins the accounts into one component.

The entity responsible for connectivity (email) becomes the DSU node.

---

## Most Stones Removed

Input

```cpp
stones = {
    {0,0},
    {0,1},
    {1,0},
    {2,2}
};
```

A stone is connected to another stone because they share

* the same row, or
* the same column.

The intuitive graph is

```text
Stone ---- Stone
```

where stones sharing a row or column are connected.

This works correctly, but every stone must be compared with every other stone.

---

Instead of making stones the nodes, observe that every stone is simply

```text
(Row, Column)
```

A stone is nothing more than a connection between one row and one column.

So represent the graph as

```text
Row -------- Column
```

Each stone becomes one edge.

For example,

```text
Stone (0,2)

becomes

Row0 -------- Col2
```

Another stone

```text
Stone (1,2)

becomes

Row1 -------- Col2
```

Now

```text
Row0 ---- Col2 ---- Row1
```

The rows become connected automatically because they share a column.

Unlike Accounts Merge, a single "row+column group" cannot be chosen as the node because connectivity can propagate through alternating rows and columns.

Example:

```text
(0,0)
(0,2)
(1,2)
```

Connection:

```text
Row0 ---- Col0
 |
Col2
 |
Row1
```

A stone can connect a row to a column, then another stone connects that column to another row, and so on.

Because connectivity alternates between rows and columns, they must be represented as separate node types.

---

## General Principle

There are usually multiple valid graph models.

One model keeps every original object as a node.

Another model represents the entity responsible for creating connectivity as the node.

Choosing the second representation often avoids building explicit connections between every individual object and produces a much simpler and more efficient DSU solution.
