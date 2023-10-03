# Alexander's (Polymorphic) Game of Life

An exploration of digital automata inspired by the original Conway's Game of Life

## Why?

I've been digging further and further into people's projects using the original
game of life, and I've long since wondered how the simulation would differ under a slightly
different implementation. Using pixels as our fundamental unit for this simulation
translates well to a computer's display, which may have been important when this simulation
was first introduced. However, once we ignore this definition, I can imagine there exists
and entirely different world of interesting patterns to be discovered. The complexity of
such a simple simulation is a marvel to witness, and I believe this project will result
in a different set of such wonder.

What if rather than pixels, I implemented this
simulation using tessellations of various shapes? This project seeks to answer that
question, while offering further practice of the GUI App development process I
was exposed to during my time in UBC's CPSC 210 course. I will be using this project to
experiment with basic graphical rendering.

## Initial Wishlist

- Control resolution of simulation
- Control shape of individual cells (thereby altering behaviour)
- Click on cells to create or destroy life

## Further Implementation

- Save (perhaps even copy/paste) patterns within/across files
- Browse previous simulations
- Move forwards and backwards through clock cycles at variable speeds