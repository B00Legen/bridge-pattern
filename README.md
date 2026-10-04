# Assignment 3 -- Bridge Pattern
### Name: Mukhammedali Bolegen
### Group: SE-2538
### Topic letter: A (Drawing)
### Repository: [Repo URL](https://github.com/B00Legen/bridge-pattern)
### Base commit hash: `fd220f5`
## Class Role Map
| Role | Class name | Source path |
|:---:|:---:|:---:|
| Abstraction | Shape | `src/Shape.java` |
| A1 | Circle | `src/Circle.java` |
| A2 | Square | `src/Square.java` |
| Implementor | Renderer | `src/Renderer.java` |
| I1 | VectorRenderer | `src/VectorRenderer.java` |
| I2 | RasterRenderer | `src/RasterRenderer.java` |
| I3 | AsciiRenderer | `src/AsciiRenderer.java` |
| Client | Main | `src/Main.java` |
## Implementation References
| Component | Location |
|:---:|:---:|
| Bridge field | `src/Shape.java` -- `protected Renderer renderer` |
| `execute()` | `src/Shape.java`, implemented inside `src/Circle.java` and `src/Square.java` |
| `setImplementation()` | `src/Shape.java` |
| T5 check | `src/Main.java` -- T5 section |
## Compilation
Compile:
`javac --release 17 -encoding UTF-8 -d out "@sources.txt"`
Run demonstration:
`java -cp out Main --demo`
## Expected Output
|Test|Configuration|Expected Output|
|:---:|:---:|:---:|
| T1 | Circle + Vector | VECTOR circle radius=2 |
| T2 | Circle + Raster | RASTER circle radius=2 |
| T3 | Square + Vector | VECTOR square side=3 |
| T4 | Square + Raster | RASTER square side=3 |
| T5 | Circle + Vector -> Raster | before=VECTOR circle radius=2, after=RASTER circle radius=2 |
| T6 | Circle + Ascii | ASCII circle radius=2 |
| T7 | Square + Ascii | ASCII square side=3 |
### T5
sameObject=true
sameId=true
sameSize=true
before=VECTOR circle radius=2
after=RASTER circle radius=2
