import { buscarLivros } from './api/googleBooks.js';

document.addEventListener('DOMContentLoaded', () => {
  const form = document.getElementById('formBusca');
  const resultados = document.getElementById('resultados');

  if (form) {
    form.addEventListener('submit', async (e) => {
      e.preventDefault();
      const query = document.getElementById('inputBusca').value;
      resultados.innerHTML = '<p>Carregando...</p>';

      try {
        const livros = await buscarLivros(query);
        resultados.innerHTML = '';

        if (livros.length === 0) {
          resultados.innerHTML = '<p>Nenhum livro encontrado.</p>';
          return;
        }

        livros.forEach(info => {
          const volume = info.volumeInfo;
          const titulo = volume.title || 'Sem título';
          const autores = volume.authors ? volume.authors.join(', ') : 'Autor desconhecido';
          const capa = volume.imageLinks?.thumbnail || '';
          const link = volume.infoLink || '#';

          resultados.innerHTML += `
            <div class="col-md-4">
              <div class="card h-100 shadow-sm">
                ${capa ? `<img src="${capa}" class="card-img-top">` : ''}
                <div class="card-body">
                  <h5 class="card-title">${titulo}</h5>
                  <p class="card-text"><strong>Autor(es):</strong> ${autores}</p>
                  <a href="${link}" class="btn btn-outline-primary" target="_blank">Ver Mais</a>
                </div>
              </div>
            </div>
          `;
        });
      } catch (err) {
        resultados.innerHTML = '<p>Erro ao buscar livros. Tente novamente.</p>';
      }
    });
  }
});
