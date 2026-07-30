class TrieNode {
    constructor() {
        this.children = new Array(26).fill(null);
        this.endOfWord = false;
    }
}

class Trie {
    constructor() {
        this.root = new TrieNode();
    }

    // Insert a word
    insert(word) {
        word = word.toLowerCase();

        let curNode = this.root;

        for (let i = 0; i < word.length; i++) {

            // char -> 0-25 index
            const index =
                word.charCodeAt(i) - 'a'.charCodeAt(0);

            if (curNode.children[index] === null) {
                curNode.children[index] = new TrieNode();
            }

            curNode = curNode.children[index];
        }

        curNode.endOfWord = true;
    }




    // Get all words starting with prefix
    getSuggestions(prefix) {
        prefix = prefix.toLowerCase();

        const suggestions = [];

        let curNode = this.root;

        // First reach prefix node
        for (let i = 0; i < prefix.length; i++) {

            const index =
                prefix.charCodeAt(i) - 'a'.charCodeAt(0);

            if (curNode.children[index] === null) {
                return suggestions;
            }

            curNode = curNode.children[index];
        }

        // Prefix itself may be a complete word
        if (curNode.endOfWord) {
            suggestions.push(prefix);
        }

        // Explore everything below prefix
        for (let i = 0; i < 26; i++) {
            this.getAllWordsFromHere(
                curNode.children[i],
                prefix,
                i,
                suggestions
            );
        }

        return suggestions;
    }


    // DFS helper
    getAllWordsFromHere(node, prefix, index, words) {

        if (node === null) {
            return;
        }

        // index -> character
        const letter =
            String.fromCharCode('a'.charCodeAt(0) + index);

        prefix = prefix + letter;

        if (node.endOfWord) {
            words.push(prefix);
        }

        for (let i = 0; i < 26; i++) {
            this.getAllWordsFromHere(
                node.children[i],
                prefix,
                i,
                words
            );
        }
    }
}




const trie = new Trie();



function insertWord() {

    const input = document.getElementById("wordInput");

    const word = input.value.trim();

    if (word === "") {
        display("Enter a word first");
        return;
    }

    trie.insert(word);

    display(`Inserted: ${word}`);

    // clear input
    input.value = "";

}



function getSuggestions() {

    const prefix =
        document.getElementById("searchBar").value.trim();

    if (prefix === "") {
        display("Enter a prefix first");
        return;
    }

    const suggestions =
        trie.getSuggestions(prefix);

    if (suggestions.length === 0) {
        display(`No words found for "${prefix}"`);
        return;
    }

    display(
        `Suggestions: ${suggestions.join(", ")}`
    );
}



function display(message) {

    document.getElementById("output").textContent = message;
    
}