const API_KEY = 'AIzaSyClr-b4Pom6iO7K3YhDEjDDTDUr5VkQNPY'; // 🔑 Substitua pela sua chave real

export async function buscarLivros(query) {
  const url = `https://www.googleapis.com/books/v1/volumes?q=${encodeURIComponent(query)}&key=${API_KEY}`;
  const resposta = await fetch(url);
  const dados = await resposta.json();
  return dados.items || [];
}
