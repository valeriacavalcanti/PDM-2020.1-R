//
//  ListarTableViewController.swift
//  Pessoas
//
//  Created by Valéria Cavalcanti on 11/12/20.
//

import UIKit

class ListarTableViewController: UITableViewController {
    
    var cadastro = Cadastro()

    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.cadastro.add(pessoa: Pessoa(nome: "Primeira Pessoa", idade: 1))
        self.cadastro.add(pessoa: Pessoa(nome: "Segunda Pessoa", idade: 2))
        self.cadastro.add(pessoa: Pessoa(nome: "Terceira Pessoa", idade: 3))
        self.cadastro.add(pessoa: Pessoa(nome: "Quarta Pessoa", idade: 4))

        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        self.navigationItem.leftBarButtonItem = self.editButtonItem
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(true)
        print(self.cadastro.get())
        self.tableView.reloadData()
    }

    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return self.cadastro.count()
    }

    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "celula", for: indexPath)

        let pessoa = self.cadastro.get(index: indexPath.row)
        
        cell.textLabel?.text = pessoa.nome
        cell.detailTextLabel?.text = String(pessoa.idade)

        return cell
    }

    // Override to support conditional editing of the table view.
    override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        return true
    }

    // Override to support editing the table view.
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCell.EditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            self.cadastro.del(index: indexPath.row)
            tableView.deleteRows(at: [indexPath], with: .fade)
        }
    }


    // Override to support rearranging the table view.
    override func tableView(_ tableView: UITableView, moveRowAt fromIndexPath: IndexPath, to: IndexPath) {
        self.cadastro.mov(from: fromIndexPath.row, to: to.row)
    }

    // Override to support conditional rearranging of the table view.
    override func tableView(_ tableView: UITableView, canMoveRowAt indexPath: IndexPath) -> Bool {
        return true
    }
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        let pessoa = self.cadastro.get(index: indexPath.row)
        
        let janela = UIAlertController(title: "Atenção", message: pessoa.description, preferredStyle: UIAlertController.Style.alert)
        janela.addAction(UIAlertAction(title: "OK", style: UIAlertAction.Style.cancel, handler: nil))
        
        self.present(janela, animated: true, completion: nil)
    }


    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if (segue.identifier == "listar_form"){
            let fvc = segue.destination as! FormViewController
            fvc.cadastro = self.cadastro
        }
    }

}
