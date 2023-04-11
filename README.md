# Documentation of Bloom Architecture

## Overall Structure

### Main Stem

TODO

### Component Stems

TODO

### Branches

TODO

### Leaves

Leaves are the smallest component of a project. They can represent either a class, method, interface, enum or an
annotation (this list is subject to change depending on programming language). Leaves
in Bloom Architecture should follow SOLID principles, with a heavy emphasis on S (SRP): Each Leaf should be as atomic
as possible, and as SRP states - it "should have only 1 reason to change". A Leaf must be attached to some Branch to
become functional and able to be used by other Leaves in its Branch. A Leaf cannot be accessed/seen/modified from
another Branch except its own. A Leaf can be extended, implemented or used in other forms only and only in its Branch.
Any information that needs to be accessed from an external Branch, should be passed to the corresponding Handler in the
Leaf's Branch,
which will handle all information transportation between Branches.

## Rules

### Creating the Main Stem

TODO

### Creating a Component Stem

TODO

### Creating a new Branch

TODO

### Creating a new Leaf

A new Leaf can be created only if there is no already existing Leaf in the desired Branch, which can perform the same
functionality with the same output as the newly created Leaf - aka no Leaf duplication is allowed. A Leaf should be
attached to Branch, only 1 at a time. Creating a Leaf should not affect any of the already existing Leaves or the Branch
itself, as it should be a completely independent unit, following all SOLID standards.

### Cutting a Component Stem

TODO

### Cutting a Branch

TODO

### Drying a Leaf

Drying a Leaf means removing it from the project completely, via deleting it from its Branch repository. A Leaf can be
dried only once, after which it should no longer be accessible by any other Leaf in its Branch and in its Branch
Handler. If the Leaf has a usage as defined [below](#a-leaf-can-be-dried-only-if), a replacement Leaf should be
created (see [Replacing a dry Leaf](#replacing-a-leaf)).

#### A Leaf can be dried only if:

* The Leaf itself, or any of its components (methods, fields, etc.) has 0 usages.
* It is not a parent class of another class, or an implemented interface.

### Replacing a Leaf

When a Leaf with some usages needs to be dried, it must have a replacement Leaf which will handle the part of its
functionality that is used in other places, or it as a whole. 

#### Here are the essential steps to follow to successfully replace a Leaf:
1. Create a new Leaf and connect it to the desired Branch (see [Creating a new Leaf](#creating-a-new-leaf))
2. Transfer the functionality of the Leaf subject to drying into the new Leaf.
3. Replace the objects, method calls, and any other usage of the old Leaf with those in the new one. 
4. Dry the old Leaf, making sure the process is done properly, as described in [Drying a Leaf](#drying-a-leaf).

## "CANNOT DO" Restrictions

### Methods

* No new parameter should be added to any existing method, if it is called X*+ times OR has a dependency tree of Y*+
  nodes**.
* A method cannot be changed to start using a field, object or call a method, if it is called X+ times OR has a
  dependency tree of Y+ nodes.
* The return type of a method cannot be changed, if the returned object is used at least 1 times.
* The access modifier of a method cannot be changed, if it is called X+ times OR has a dependency tree of Y+.
* Recommended: The complexity of a method cannot be increased, if it is called X+ times OR has a dependency tree of Y+
  nodes. (This may be a good restriction for big projects, where even a small increase in the compilation and/or
  execution time may be crucial).

### Classes

* A class cannot implement a new Interface, if its constructor or other methods are called X+ times OR have a
  dependency tree of Y+ nodes.

* A class cannot extend a new class, if its constructor or other methods are called X*+ times OR have a
  dependency tree of Y*+ nodes.

* A method in a class cannot be overrided, if the original method is at least 1 times.

*X and Y should be set according to the project's size and specifications. In general, it is recommended to have X = Y <
= 3.

**dependency tree is a tree that represents the area of affection of a method, aka how many other
methods/classes/fields, etc. call it, and how deep does its result go to other components of the project. e.g. if the '
f()' method returns a K value that is later used in 'fun()' method and the 'fun()' method is later called in 'A' class,
then this method has a dependency tree of Y=2 nodes, which means that the value K has been used in 2 other places.
