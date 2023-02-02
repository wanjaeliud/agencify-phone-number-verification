import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { DataService } from './services/data.service';
// @ts-ignore
import * as _ from 'lodash';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  displayedColumns = ['country','phone','state'];
  dataSource!:MatTableDataSource<any>;
  apiResponse:any = [];

  @ViewChild('paginator') paginator! : MatPaginator;
  @ViewChild(MatSort) matSort! : MatSort;

  constructor(private service: DataService) {}

  ngOnInit() {
    this.service.getCountryData().subscribe((response:any) =>{
      this.apiResponse = response;
      this.dataSource = new MatTableDataSource(response);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.matSort;
    })
  }


  filterData($event : any){
    this.dataSource.filter = $event.target.value;
  }

  onChange($event:any){
    let filteredData = _.filter(this.apiResponse,(item: { state: string; }) =>{
      return item.state.toLowerCase() ==  $event.value.toLowerCase();
    })
    this.dataSource = new MatTableDataSource(filteredData);
  }


}
