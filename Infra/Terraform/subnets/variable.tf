variable "vpc_id" {
  description = "vpc id to be overriden"
}

variable "cidrblock" {
  type = map
  default = {
    cidr1 = "10.0.1.0/24"
    cidr2 = "10.0.3.0/24"
    cidr3 = "10.0.4.0/24"
  }
}

variable "az" {
  type = map
  default = {
    zone1 = "eu-west-1a"
    zone1 = "eu-west-1b"
    zone1 = "eu-west-1c"
  }
}