import java.util.List;
import java.util.ArrayList;

public class Main {
    class Tree {
        int value;
        List<Tree> children;
   
        Tree(int value, List<Tree> children) {
            this.value = value;
            this.children = children;
        }
    }

    public int minimaxRunner(Tree node, boolean maxLevel, int depth) {
        if (node.children.isEmpty() || depth == 0) {
            return node.value;
        }

        if (maxLevel) {
            int value = Integer.MIN_VALUE;
            for (Tree child : node.children) {
                int minimaxValue = minimaxRunner(child, false, depth - 1);
                value = Math.max(value, minimaxValue);
            }
            return value;
        } else {
            int value = Integer.MAX_VALUE;
            for (Tree child : node.children) {
                int minimaxValue = minimaxRunner(child, true, depth - 1);
                value = Math.min(value, minimaxValue);
            }
            return value;
        }
    }

    public int alphaBetaPruningRunner(Tree node, boolean maxLevel, int alpha, int beta, int depth) {
        if (node.children.isEmpty() || depth == 0) {
            return node.value;
        }

        if (maxLevel) {
            int value = Integer.MIN_VALUE;
            for (Tree child : node.children) {
                int minimaxValue = alphaBetaPruningRunner(child, false, alpha, beta, depth - 1);
                value = Math.max(value, minimaxValue);
                alpha = Math.max(alpha, minimaxValue);
                if (beta <= alpha) {
                    break;
                }
            }
            return value;
        } else {
            int value = Integer.MAX_VALUE;
            for (Tree child : node.children) {
                int minimaxValue = alphaBetaPruningRunner(child, true, alpha, beta, depth - 1);
                value = Math.min(value, minimaxValue);
                beta = Math.min(beta, minimaxValue);
                if (beta <= alpha) {
                    break;
                }
            }
            return value;
        }
    }
   
    Tree twoPlayer() {
        Tree treeNode = new Tree(
            Integer.MIN_VALUE,
            List.of(
                new Tree(
                    Integer.MIN_VALUE,
                    List.of(
                        new Tree(2, new ArrayList<>()),
                        new Tree(1, new ArrayList<>())
                    )
                ),
                new Tree(
                    Integer.MIN_VALUE,
                    List.of(
                        new Tree(4, new ArrayList<>()),
                        new Tree(3, new ArrayList<>())
                    )
                )
            )
        );
        return treeNode;
    }

    Tree fourPlayer1() {
        Tree treeNode = new Tree(
            Integer.MIN_VALUE,
            List.of(
                new Tree(
                    Integer.MIN_VALUE,
                    List.of(
                        new Tree(-14, new ArrayList<>()),
                        new Tree(-9, new ArrayList<>()),
                        new Tree(2, new ArrayList<>()),
                        new Tree(7, new ArrayList<>())
                    )
                ),
                new Tree(
                    Integer.MIN_VALUE,
                    List.of(
                        new Tree(-2, new ArrayList<>()),
                        new Tree(-16, new ArrayList<>()),
                        new Tree(4, new ArrayList<>()),
                        new Tree(14, new ArrayList<>())
                    )
                ),
                new Tree(
                    Integer.MIN_VALUE,
                    List.of(
                        new Tree(6, new ArrayList<>()),
                        new Tree(-4, new ArrayList<>()),
                        new Tree(-1, new ArrayList<>()),
                        new Tree(9, new ArrayList<>())
                    )
                ),
                new Tree(
                    Integer.MIN_VALUE,
                    List.of(
                        new Tree(3, new ArrayList<>()),
                        new Tree(-3, new ArrayList<>()),
                        new Tree(12, new ArrayList<>()),
                        new Tree(11, new ArrayList<>())
                    )
                )
            )
        );
        return treeNode;
    }

    Tree fourPlayer2() {
        Tree treeNode = new Tree(
            Integer.MIN_VALUE,
            List.of(
                new Tree(
                    Integer.MIN_VALUE,
                    List.of(
                        new Tree(4, new ArrayList<>()),
                        new Tree(-19, new ArrayList<>()),
                        new Tree(2, new ArrayList<>()),
                        new Tree(14, new ArrayList<>())
                    )
                ),
                new Tree(
                    Integer.MIN_VALUE,
                    List.of(
                        new Tree(12, new ArrayList<>()),
                        new Tree(15, new ArrayList<>()),
                        new Tree(3, new ArrayList<>()),
                        new Tree(11, new ArrayList<>())
                    )
                ),
                new Tree(
                    Integer.MIN_VALUE,
                    List.of(
                        new Tree(6, new ArrayList<>()),
                        new Tree(-2, new ArrayList<>()),
                        new Tree(-10, new ArrayList<>()),
                        new Tree(18, new ArrayList<>())
                    )
                ),
                new Tree(
                    Integer.MIN_VALUE,
                    List.of(
                        new Tree(3, new ArrayList<>()),
                        new Tree(1, new ArrayList<>()),
                        new Tree(7, new ArrayList<>()),
                        new Tree(-4, new ArrayList<>())
                    )
                )
            )
        );
        return treeNode;
    }

    Tree fourPlayer3() {
        Tree treeNode = new Tree(
            Integer.MIN_VALUE,
            List.of(
                new Tree(
                    Integer.MIN_VALUE,
                    List.of(
                        new Tree(21, new ArrayList<>()),
                        new Tree(-18, new ArrayList<>()),
                        new Tree(12, new ArrayList<>()),
                        new Tree(16, new ArrayList<>())
                    )
                ),
                new Tree(
                    Integer.MIN_VALUE,
                    List.of(
                        new Tree(14, new ArrayList<>()),
                        new Tree(15, new ArrayList<>()),
                        new Tree(19, new ArrayList<>()),
                        new Tree(11, new ArrayList<>())
                    )
                ),
                new Tree(
                    Integer.MIN_VALUE,
                    List.of(
                        new Tree(-10, new ArrayList<>()),
                        new Tree(18, new ArrayList<>())
                    )
                ),
                new Tree(
                    Integer.MIN_VALUE,
                    List.of(
                        new Tree(1, new ArrayList<>()),
                        new Tree(7, new ArrayList<>()),
                        new Tree(-4, new ArrayList<>())
                    )
                )
            )
        );
        return treeNode;
    }

    public static void main(String[] args) {
        Main program = new Main();
        System.out.println("Minimax with 2 Players = " + program.minimaxRunner(program.twoPlayer(), true, 3));
        System.out.println("Alpha-Beta Pruning with 2 Players = " + program.alphaBetaPruningRunner(program.twoPlayer(), true, Integer.MIN_VALUE, Integer.MAX_VALUE, 3));
        System.out.println("Alpha-Beta Pruning with 4 Players 1 = " + program.alphaBetaPruningRunner(program.fourPlayer1(), true, Integer.MIN_VALUE, Integer.MAX_VALUE, 3));
        System.out.println("Alpha-Beta Pruning with 4 Players 2 = " + program.alphaBetaPruningRunner(program.fourPlayer2(), true, Integer.MIN_VALUE, Integer.MAX_VALUE, 3));
        System.out.println("Alpha-Beta Pruning with 4 Players 3 = " + program.alphaBetaPruningRunner(program.fourPlayer3(), true, Integer.MIN_VALUE, Integer.MAX_VALUE, 3));
    }
}