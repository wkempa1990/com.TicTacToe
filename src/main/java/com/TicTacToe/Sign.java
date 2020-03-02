package com.TicTacToe;

    public enum Sign {
        O("O"),
        X("X"),
        EMPTY("_");
        String name;
        Sign(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }