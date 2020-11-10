//
//  ViewController.swift
//  Primeiro App iOS
//
//  Created by Valéria Cavalcanti on 10/11/20.
//

import UIKit

class MainViewController: UIViewController {

    @IBOutlet weak var lbInstituicao: UILabel!
    
    @IBAction func exibir(_ sender: Any) {
        self.lbInstituicao.text = "IFPB"
    }
    
}

