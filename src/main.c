#include <stdio.h>
#include <stdlib.h>

// Definição da estrutura TreeNode
struct TreeNode {
    int val;
    struct TreeNode* esquerda;
    struct TreeNode* direita;
};

// Função auxiliar para encontrar o segundo valor mínimo diferente de um dado valor
int findDif(struct TreeNode* root, int val) {
    if (root == NULL)
        return -1;

    if (root->val != val)
        return root->val;

    int leftValue = findDif(root->esquerda, val);
    int rightValue = findDif(root->direita, val);

    if (leftValue == -1)
        return rightValue;

    if (rightValue == -1)
        return leftValue;

    return fmin(leftValue, rightValue);
}

// Função principal para encontrar o segundo valor mínimo diferente
int findSecondMinimumValue(struct TreeNode* root) {
    // Vai chamar a função findDif com a raiz da árvore e o valor da raiz
    return findDif(root, root->val);
}

int main() {
    // Criar a árvore de exemplo: [2, 2, 5, null, null, 5, 7]
    struct TreeNode* root = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    root->val = 2;
    root->esquerda = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    root->esquerda->val = 2;
    root->esquerda->esquerda = NULL;
    root->esquerda->direita = NULL;
    root->direita = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    root->direita->val = 5;
    root->direita->esquerda = NULL;
    root->direita->direita = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    root->direita->direita->val = 7;
    root->direita->direita->esquerda = NULL;
    root->direita->direita->direita = NULL;

    int result = findSecondMinimumValue(root);
    printf("Second minimum value: %d\n", result); // Output esperado: 5

    // Lembre-se de liberar a memória alocada para os nós da árvore após o uso
    // Liberar(root);

    return 0;
}
